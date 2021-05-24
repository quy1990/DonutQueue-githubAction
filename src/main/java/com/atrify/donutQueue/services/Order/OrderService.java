package com.atrify.donutQueue.services.Order;

import com.atrify.donutQueue.entities.Order;
import org.springframework.stereotype.Service;

@Service
public interface  OrderService {

    Order create(Order order);

    void delete(Long clientId);
}
