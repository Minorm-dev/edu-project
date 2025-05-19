package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {

    Optional<PromoCode> findByCode(String promoCode);

    @Query("SELECT p FROM PromoCode p WHERE p.validTo > CURRENT_TIMESTAMP")
    List<PromoCode> findActivePromoCodes();
}
