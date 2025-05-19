package com.minorm.eduproject.http.validation;

import com.minorm.eduproject.database.repository.PromoCodeRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class PromoCodeValidator implements ConstraintValidator<ValidPromoCode, String > {

    private final PromoCodeRepository promoCodeRepository;

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        return promoCodeRepository.findByCode(code)
                .filter(p -> p.getValidTo().isAfter(LocalDateTime.now()))
                .isPresent();
    }
}
