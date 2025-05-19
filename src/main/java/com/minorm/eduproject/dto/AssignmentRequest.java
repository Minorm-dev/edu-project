package com.minorm.eduproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AssignmentRequest(
        @NotBlank @Size(max = 5000) String answer
) {
}
