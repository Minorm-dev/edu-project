package com.minorm.eduproject.mapper;

import com.minorm.eduproject.database.entity.User;
import com.minorm.eduproject.dto.UserRequest;
import com.minorm.eduproject.dto.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "courses", ignore = true)
    @Mapping(target = "enrollments", ignore = true)
    User fromRequest(UserRequest request);

    @Mapping(target = "avatarPath", source = "avatarPath")
    UserResponse toResponse(User user);

    List<UserResponse> toResponseList(List<User> users);
}
