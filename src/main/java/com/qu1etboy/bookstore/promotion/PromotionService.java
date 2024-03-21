package com.qu1etboy.bookstore.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromotionService {
    @Autowired
    private PromotionCatalog promotionCatalog;

    @Autowired
    private PromotionFactory promotionFactory;

    public void addPromotion(PromotionRequest request) {
        promotionCatalog.put(request.getCode(), promotionFactory.createPromotion(request.getType(), request.getValue()));
    }

    public Promotion getPromotion(String code) {
        return promotionCatalog.get(code);
    }
}
