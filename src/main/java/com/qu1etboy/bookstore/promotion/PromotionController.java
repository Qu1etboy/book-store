package com.qu1etboy.bookstore.promotion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/promotions")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public String addPromotion(@Valid @RequestBody PromotionRequest request) {
        promotionService.addPromotion(request);
        return "Promotion added successfully.";
    }

//    @GetMapping("/{code}")
//    public String getPromotion(@PathVariable String code) {
//        Promotion promotion = promotionService.getPromotion(code);
//        try {
//            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(promotion);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            return "Error occurred while processing the request. Please try again later.";
//        }
//    }
}
