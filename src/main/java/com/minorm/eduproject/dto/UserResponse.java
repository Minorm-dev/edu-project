package com.minorm.eduproject.dto;

import com.minorm.eduproject.database.entity.Role;

import java.time.Instant;
import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String email,
        String firstName,
        String lastName,
        String avatarPath,
        Role role,
        Instant createdAt
) {

}
