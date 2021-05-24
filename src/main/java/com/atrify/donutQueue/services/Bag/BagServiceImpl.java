package com.atrify.donutQueue.services.Bag;

import com.atrify.donutQueue.dataTranferObjects.Bag;
import com.atrify.donutQueue.dataTranferObjects.OrderDTO;
import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.exceptions.BagNotFoundException;
import com.atrify.donutQueue.exceptions.ClientNotFoundException;
import com.atrify.donutQueue.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BagServiceImpl implements BagService {

    @Autowired
    OrderRepository orderRepository;

    public Bag getBag(int id) {
        List<Bag> bags = getBags();
        if (bags.size() <= id || bags.get(id) == null) {
            throw new BagNotFoundException();
        }
        return bags.get(id);
    }

    public OrderDTO getWaitTime(Long clientId) {
        List<Bag> bags = getBags();
        for (Bag bag : bags) {
            for (Order order : bag.getOrders()) {
                if (order.getClientId().equals(clientId)) {
                    OrderDTO orderDTO = new OrderDTO();
                    orderDTO.setId(order.getId());
                    orderDTO.setClientId(order.getClientId());
                    orderDTO.setApproximateTime(bag.getApproximateTime());
                    orderDTO.setQuantity(order.getQuantity());
                    orderDTO.setCreatedDate(order.getCreatedDate());
                    return orderDTO;
                }
            }
        }

        throw new ClientNotFoundException();
    }

    @Override
    public List<Bag> getBags() {
        return null;
    }

    public List<Bag> getBags(List<Order> orders) {
        List<Bag> bags = new ArrayList<>();
        Bag jimBag = new Bag();
        int index = 1;

        // Put orders in to jim's Bag
        for (Order order : orders) {
            if (!jimBag.add(order)) {
                bags.add(jimBag);
                jimBag = new Bag(order);
                jimBag.setIndexOfBag(++index);
            }
        }

        // Put latest order in to jim's Bag
        if (jimBag.getOrders().size() > 0) {
            bags.add(jimBag);
        }
        return bags;
    }
}
