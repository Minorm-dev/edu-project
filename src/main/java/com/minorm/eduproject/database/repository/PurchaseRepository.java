package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findByStudentId(Long studentId);

    Optional<Purchase> findByTransactionId(String transactionId);

    @Query("SELECT COUNT(p) FROM Purchase p WHERE p.promoCode.id = :promoCodeId")
    int countByPromoCodeId(@Param("promoCodeId") Long promoCodeId);
}
