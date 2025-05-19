package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.Review;
import com.minorm.eduproject.dto.ReviewRequest;
import com.minorm.eduproject.dto.ReviewResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(target = "student", ignore = true)
    @Mapping(target = "course", ignore = true)
    Review fromRequest(ReviewRequest request);

    @Mapping(target = "studentName", expression = "java(review.getStudent().getFullName())")
    ReviewResponse toResponse(Review review);
}
