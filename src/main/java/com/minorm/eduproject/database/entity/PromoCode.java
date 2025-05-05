package com.minorm.eduproject.database.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "promo_codes", uniqueConstraints = @UniqueConstraint(
        name = "uc_promo_code_code",
        columnNames = "code"
))
public class PromoCode extends BaseEntity{

    @Column(nullable = false, length = 20)
    private String code;  // Сам промокод

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiscountType discountType; // тип скидки Процент или Фиксированная

    @Column(nullable = false)
    private BigDecimal discountValue;

    @Column(nullable = false)
    private LocalDateTime validFrom;

    @Column(nullable = false)
    private LocalDateTime validTo;

    @OneToMany(mappedBy = "promoCode")
    @Builder.Default
    private List<Purchase> purchases = new ArrayList<>();

}
