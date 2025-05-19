package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Refund;
import com.minorm.eduproject.dto.RefundRequest;
import com.minorm.eduproject.dto.RefundResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RefundMapper {

    @Mapping(target = "purchase", ignore = true)
    Refund fromRequest(RefundRequest request);

    RefundResponse toResponse(Refund refund);
}
