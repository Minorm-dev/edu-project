package com.minorm.eduproject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RefundRequest(
        @NotBlank @Size(max = 2000) String reason
) {
}
