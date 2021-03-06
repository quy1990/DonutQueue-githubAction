package com.atrify.donutQueue.services.OrderServices;

import com.atrify.donutQueue.dataTranferObjects.BagDTO;
import com.atrify.donutQueue.entities.Order;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getClientId() <= BagDTO.PRIORITY_NUMBER && order2.getClientId() <= BagDTO.PRIORITY_NUMBER) {
            return order1.getCreatedDate().compareTo(order2.getCreatedDate());
        }

        if (order1.getClientId() <= BagDTO.PRIORITY_NUMBER) {
            return -1;
        }

        if (order2.getClientId() <= BagDTO.PRIORITY_NUMBER) {
            return 1;
        }

        return order1.getCreatedDate().compareTo(order2.getCreatedDate());
    }
}