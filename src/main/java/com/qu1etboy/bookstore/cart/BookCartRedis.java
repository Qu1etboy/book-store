package com.qu1etboy.bookstore.cart;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("bookCartRedis")
public class BookCartRedis implements BookCart {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<BookOrderRequest> getBookOrders() {
        try {
            return objectMapper.readValue(redisTemplate.opsForValue().get("bookOrders"), new TypeReference<>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void setBookOrders(List<BookOrderRequest> bookOrders) {
        try {
            redisTemplate.opsForValue().set("bookOrders", objectMapper.writeValueAsString(bookOrders));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
