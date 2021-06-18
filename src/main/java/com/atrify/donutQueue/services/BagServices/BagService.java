package com.atrify.donutQueue.services.BagServices;

import com.atrify.donutQueue.dataTranferObjects.BagDTO;
import com.atrify.donutQueue.dataTranferObjects.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BagService {

    BagDTO getBag(int id);

    OrderDTO getWaitTime(Long clientId);

    List<BagDTO> getBags();
}
