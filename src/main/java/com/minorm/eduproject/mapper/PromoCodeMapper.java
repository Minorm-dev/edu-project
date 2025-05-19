package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.PromoCode;
import com.minorm.eduproject.dto.PromoCodeRequest;
import com.minorm.eduproject.dto.PromoCodeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PromoCodeMapper {

    @Mapping(target = "purchases", ignore = true)
    PromoCode fromRequest(PromoCodeRequest request);

    PromoCodeResponse toResponse(PromoCode promoCode);
}
