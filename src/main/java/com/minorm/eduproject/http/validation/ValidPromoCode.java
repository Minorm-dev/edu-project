package com.minorm.eduproject.http.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PromoCodeValidator.class)
public @interface ValidPromoCode {
    String message() default "Invalid Promo Code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
