package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Purchase;
import com.minorm.eduproject.dto.PurchaseRequest;
import com.minorm.eduproject.dto.PurchaseResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    @Mapping(target = "promoCode", ignore = true)
    Purchase fromRequest(PurchaseRequest request);

    @Mapping(target = "courseTitle", source = "course.title")
    @Mapping(target = "discountApplied", expression = "java(calculateDiscount(purchase))")
    PurchaseResponse toResponse(Purchase purchase);

    default BigDecimal calculateDiscount(Purchase purchase) {
        if (purchase.getPromoCode() == null) return BigDecimal.ZERO;

        return switch (purchase.getPromoCode().getDiscountType()) {
            case FIXED_AMOUNT -> purchase.getPromoCode().getDiscountValue();
            case PERCENT -> purchase.getAmount()
                    .multiply(purchase.getPromoCode().getDiscountValue())
                    .divide(BigDecimal.valueOf(100));
        };
    }
}
