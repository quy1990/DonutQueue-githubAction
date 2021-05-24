package com.atrify.donutQueue.unitTest;

import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.exceptions.OrderExistedException;
import com.atrify.donutQueue.repositories.OrderRepository;
import com.atrify.donutQueue.services.Order.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class orderServiceUnitTest {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderService orderService;

    Order order;

    orderServiceUnitTest() {
        order = new Order();
        order.setQuantity(1);
        order.setClientId(999999L);
    }

    @BeforeEach
    public void init() {
        orderService.create(order);
    }

    @AfterEach
    public void teardown() {
        orderService.delete(order.getClientId());
    }

    @Test
    void create() {
        Assertions.assertNotNull(orderRepository.getByClientId(order.getClientId()));
    }

    @Test
    void create_order_with_the_same_clientId_Should_Throw_Exception() {
        Assertions.assertThrows(OrderExistedException.class, () -> orderService.create(order));
    }

    @Test
    void deletion() {
        orderService.delete(order.getClientId());
        Assertions.assertNull(orderRepository.getByClientId(order.getClientId()));
    }
}
