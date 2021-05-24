package com.atrify.donutQueue.controllers.v1;


import com.atrify.donutQueue.dataTranferObjects.Bag;
import com.atrify.donutQueue.exceptions.BagNotFoundException;
import com.atrify.donutQueue.services.Bag.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Version 1.0
 * This controller will work with Bag Object
 */
@RestController
@RequestMapping(path = "/api/v1/bags")
public class BagV1Controller {

    @Autowired
    @Qualifier(value = "BagServiceJava")
    BagService bagServiceJava;

    /**
     * get all bags in System is used by Manager
     */
    @GetMapping
    public ResponseEntity<List<Bag>> index() {
        try {
            return new ResponseEntity<List<Bag>>(bagServiceJava.getBags(), HttpStatus.OK);
        } catch (BagNotFoundException exception) {
            return new ResponseEntity<List<Bag>>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<List<Bag>>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /**
     * get first bag in Queue and can be used by jim
     */
    @GetMapping("/first")
    public ResponseEntity<Bag> getFirst() {
        try {
            return new ResponseEntity<Bag>(bagServiceJava.getBag(0), HttpStatus.OK);
        } catch (BagNotFoundException exception) {
            return new ResponseEntity<Bag>(HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            return new ResponseEntity<Bag>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
