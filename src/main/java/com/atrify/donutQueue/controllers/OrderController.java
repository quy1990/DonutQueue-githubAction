package com.atrify.donutQueue.controllers;

import com.atrify.donutQueue.dataTranferObjects.OrderDTO;
import com.atrify.donutQueue.entities.Order;
import com.atrify.donutQueue.exceptions.ClientNotFoundException;
import com.atrify.donutQueue.exceptions.OrderExistedException;
import com.atrify.donutQueue.exceptions.OrderNotFoundException;
import com.atrify.donutQueue.services.Bag.BagService;
import com.atrify.donutQueue.services.Order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * this Controller will work with order object
 */
@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    BagService bagServiceJava;

    /**
     * this function creates new Order for Customer
     */
    @PostMapping
    public ResponseEntity<Order> create(@RequestParam Long clientId, @RequestParam Integer quantity) {
        try {
            return new ResponseEntity<Order>(orderService.create(new Order(clientId, quantity)), HttpStatus.CREATED);
        } catch (OrderExistedException exception) {
            return new ResponseEntity<Order>(HttpStatus.CONFLICT);
        } catch (Exception exception) {
            return new ResponseEntity<Order>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * this function returns waiting-time of clientId in system
     */
    @GetMapping("/{clientId}/wait-time")
    public ResponseEntity<OrderDTO> getQueueByClientId(@PathVariable Long clientId) {
        try {
            return new ResponseEntity<OrderDTO>(bagServiceJava.getWaitTime(clientId), HttpStatus.OK);
        } catch (ClientNotFoundException exception) {
            return new ResponseEntity<OrderDTO>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<OrderDTO>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * Delete a order by clientId
     */
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Order> delete(@PathVariable Long clientId) {
        try {
            orderService.delete(clientId);
            return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
        } catch (OrderNotFoundException exception) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<Order>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
