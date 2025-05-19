package com.minorm.eduproject.database.repository;

import com.minorm.eduproject.database.entity.Refund;
import com.minorm.eduproject.database.entity.RefundStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RefundRepository extends JpaRepository<Refund, Long> {

    List<Refund> findByPurchaseId(Long purchaseId);

    List<Refund> findByStatus(RefundStatus refundStatus);
}
