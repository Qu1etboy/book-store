package com.qu1etboy.bookstore.order;

import com.qu1etboy.bookstore.book.Book;
import com.qu1etboy.bookstore.book.BookService;
import com.qu1etboy.bookstore.cart.BookCartService;
import com.qu1etboy.bookstore.cart.BookOrderRequest;
import com.qu1etboy.bookstore.promotion.Promotion;
import com.qu1etboy.bookstore.promotion.PromotionCatalog;
import com.qu1etboy.bookstore.promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookCartService bookCartService;

    @Autowired
    private PromotionCatalog promotionCatalog;

    public List<PurchaseOrder> getOrders() {
        return orderRepository.findAll();
    }

    public PurchaseOrder createOrUpdateOrder() {
        PurchaseOrder purchaseOrder = orderRepository.findPendingOrder().orElseGet(PurchaseOrder::new);
        List<BookOrderRequest> bookCart = bookCartService.getBookOrders();

        // Clear old order items
        purchaseOrder.setOrderItems(new ArrayList<>());

        for (BookOrderRequest bookOrderRequest : bookCart) {
            Book book = bookService.getBookById(bookOrderRequest.getBookId());

            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(bookOrderRequest.getQuantity());

            purchaseOrder.addOrderItem(orderItem);
        }

        return orderRepository.save(purchaseOrder);
    }

    public PurchaseOrder usePromotion(String code) {
        // Find the pending order
        PurchaseOrder purchaseOrder = orderRepository.findPendingOrder().orElseThrow();

        // Apply the promotion
        purchaseOrder.addPromotionCode(code);

        return orderRepository.save(purchaseOrder);
    }

    public Cashier checkout() {
        // Find the pending order
        PurchaseOrder purchaseOrder = orderRepository.findPendingOrder().orElseThrow();

        return new Cashier(purchaseOrder, promotionCatalog);
    }

    public void payOrder() {
        // Find the pending order
        PurchaseOrder purchaseOrder = orderRepository.findPendingOrder().orElseThrow();

        // Pay the order
        System.out.println("Paying order: " + purchaseOrder.getId());

        // Change the order status
        purchaseOrder.setStatus(OrderStatus.PAID);
        orderRepository.save(purchaseOrder);

        // Create a receipt
    }

    public void deleteOrders() {
        orderRepository.deleteAll();
    }
}
