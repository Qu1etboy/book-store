package com.qu1etboy.bookstore.promotion;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PromotionRequest {
    @NotBlank(message = "Code is mandatory")
    private String code;

    @NotBlank(message = "Type is mandatory")
    private String type;

    @Min(value = 0, message = "Value must be positive")
    private double value;
}
