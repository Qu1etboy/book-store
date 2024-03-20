package com.qu1etboy.bookstore.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<PurchaseOrder, Long> {

    /**
     * Find the pending order.
     * User can only have one pending order at a time.
     *
     * @return the pending order
     */
    @Query("SELECT o FROM PurchaseOrder o WHERE o.status = com.qu1etboy.bookstore.order.OrderStatus.PENDING")
    Optional<PurchaseOrder> findPendingOrder();

}
