package com.atrify.donutQueue.services.Bag;

import com.atrify.donutQueue.dataTranferObjects.Bag;
import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.services.Order.OrderComparator;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Primary
@Component("BagServiceJava")
public class BagServiceJava extends BagServiceImpl {

    @Override
    public List<Bag> getBags() {
        Queue<Order> orders = getOrdersSortByPriorityNumberAndSortByCreateDateInJava();
        List<Order> result = new ArrayList<>(orders.size());
        while (!orders.isEmpty()) {
            result.add(orders.poll());
        }
        return getBags(result);
    }


    /**
     * Get and sort Order by Priority Number and By Created_date in Java
     * It is slower than in SQl Query
     */
    private Queue<Order> getOrdersSortByPriorityNumberAndSortByCreateDateInJava() {
        Queue<Order> ordersQueue = new PriorityQueue<>(new OrderComparator());
        ordersQueue.addAll((Collection<? extends Order>) orderRepository.findAll());
        if (ordersQueue.size() > 0) {
            return ordersQueue;
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
    }
}
