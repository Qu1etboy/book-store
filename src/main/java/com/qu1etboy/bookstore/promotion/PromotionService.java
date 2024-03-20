package com.qu1etboy.bookstore.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionCatalog promotionCatalog;

    public void addPromotion(PromotionRequest request) {
        promotionCatalog.put(request.getCode(), PromotionFactory.createPromotion(request.getType(), request.getValue()));
    }

    public Promotion getPromotion(String code) {
        return promotionCatalog.get(code);
    }
}
