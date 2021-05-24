package com.atrify.donutQueue.unitTest;

import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.repositories.OrderRepository;
import com.atrify.donutQueue.services.Bag.BagService;
import org.junit.After;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class bagServiceUnitTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BagService bagService;

    @After
    public void teardown() {
        orderRepository.deleteByClientId(100L);
    }

    @Test
    void getWaitingTime() {
        orderRepository.deleteByClientId(100L);
        Order order = new Order();
        order.setQuantity(1);
        order.setClientId(100L);
        order.setCreatedDate(LocalDateTime.now());
        orderRepository.save(order);
        Assertions.assertEquals("15 Minutes", bagService.getWaitTime(100L).getApproximateTime());
    }
}
