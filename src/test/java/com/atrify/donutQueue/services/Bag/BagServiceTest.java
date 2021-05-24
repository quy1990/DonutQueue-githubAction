package com.atrify.donutQueue.services.Bag;

import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.repositories.OrderRepository;
import com.atrify.donutQueue.services.Order.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BagServiceTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    BagService bagService;

    @Autowired
    OrderService orderService;

    Order order;

    BagServiceTest() {
        order = new Order();
        order.setQuantity(1);
        order.setClientId(200L);
        order.setCreatedDate(LocalDateTime.now());
    }

    @BeforeEach
    void setUp() {
        orderRepository.save(order);
    }

    @AfterEach
    void tearDown() {
        orderService.delete(order.getClientId());
    }

    @Test
    void getBag() {
        Assertions.assertNotNull(bagService.getBag(0));
    }

    @Test
    void getWaitTime() {
        Assertions.assertNotNull(bagService.getWaitTime(order.getClientId()).getApproximateTime());
    }

    @Test
    void getBags() {
        Assertions.assertTrue(bagService.getBags().size() > 0);
    }
}