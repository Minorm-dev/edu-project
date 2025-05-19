package com.minorm.eduproject.dto;

import com.minorm.eduproject.http.validation.ValidPromoCode;
import jakarta.validation.constraints.NotNull;

public record PurchaseRequest(
        @NotNull Long courseId,
        @ValidPromoCode String promoCode
) {
}
