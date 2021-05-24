package com.atrify.donutQueue.services.Bag;

import com.atrify.donutQueue.dataTranferObjects.Bag;
import com.atrify.donutQueue.dataTranferObjects.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BagService {

    Bag getBag(int id);

    OrderDTO getWaitTime(Long clientId);

    List<Bag> getBags();
}
