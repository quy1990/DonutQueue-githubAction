package com.atrify.donutQueue.services.Order;

import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.exceptions.OrderExistedException;
import com.atrify.donutQueue.exceptions.OrderMissingInformationException;
import com.atrify.donutQueue.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Order create(Order order) {
        boolean isOrderNotNull = (null != order.getClientId());
        boolean isQuantityPositive = (order.getQuantity() > 0);
        boolean isOrderNotExist = (findOrderIfExists(order.getClientId()) == null);

        if (isOrderNotNull && isQuantityPositive && isOrderNotExist) {
            orderRepository.save(order);
            return findOrderIfExists(order.getClientId());
        } else {
            if (!isOrderNotExist) {
                throw new OrderExistedException();
            }
            throw new OrderMissingInformationException();
        }
    }

    @Override
    public void delete(Long clientId) {
        orderRepository.deleteByClientId(clientId);
    }

    private Order findOrderIfExists(Long clientId) {
        return orderRepository.getByClientId(clientId);
    }
}
