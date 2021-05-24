package com.atrify.donutQueue.dataTranferObjects;

import com.atrify.donutQueue.entities.Order;

import java.util.ArrayList;
import java.util.List;

public class Bag {

    public static int PRIORITY_NUMBER = 1000;
    int indexOfBag;
    int CAPACITY = 50;
    int time_to_process = 5; // 5 Minutes
    List<Order> orders = new ArrayList<>();

    public Bag() {
        indexOfBag = 1;
    }

    public Bag(Order order) {
        if (canAdd(order)) {
            orders.add(order);
        }
    }

    public boolean add(Order order) {
        if (canAdd(order)) {
            orders.add(order);
            return true;
        }
        return false;
    }

    private boolean canAdd(Order order) {
        return this.getSumOfDonut() + order.getQuantity() <= CAPACITY;
    }

    public int getSumOfDonut() {
        int sumOfDonut = 0;
        for (Order order : orders) {
            sumOfDonut += order.getQuantity();
        }
        return sumOfDonut;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getIndexOfBag() {
        return indexOfBag;
    }

    public void setIndexOfBag(int indexOfBag) {
        this.indexOfBag = indexOfBag;
    }

    public String getApproximateTime() {
        return (indexOfBag * time_to_process) + " Minutes";
    }


}
