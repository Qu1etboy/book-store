package com.qu1etboy.bookstore.promotion;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @PostMapping
    public String addPromotion(@Valid @RequestBody PromotionRequest request) {
        promotionService.addPromotion(request);
        return "Promotion added successfully.";
    }
}
