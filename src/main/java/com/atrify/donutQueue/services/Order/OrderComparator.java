package com.atrify.donutQueue.services.Order;

import com.atrify.donutQueue.dataTranferObjects.Bag;
import com.atrify.donutQueue.entities.Order;
import org.springframework.stereotype.Service;

import java.util.Comparator;

@Service
public class OrderComparator implements Comparator<Order> {

    @Override
    public int compare(Order order1, Order order2) {
        if (order1.getClientId() <= Bag.PRIORITY_NUMBER && order2.getClientId() <= Bag.PRIORITY_NUMBER) {
            return order1.getCreatedDate().compareTo(order2.getCreatedDate());
        }
        if (order1.getClientId() <= Bag.PRIORITY_NUMBER
                && order2.getClientId() > Bag.PRIORITY_NUMBER) {
            return -1;
        }
        if (order2.getClientId() <= Bag.PRIORITY_NUMBER
                && order1.getClientId() > Bag.PRIORITY_NUMBER) {
            return 1;
        }

        return order1.getCreatedDate().compareTo(order2.getCreatedDate());
    }
}