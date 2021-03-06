package com.atrify.donutQueue.services.BagServices;

import com.atrify.donutQueue.dataTranferObjects.BagDTO;
import com.atrify.donutQueue.entities.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component("BagServiceSQL")
public class BagServiceSQL extends BagServiceImpl{

    @Override
    public List<BagDTO> getBags() {
        List<Order> orders = getSortedOrdersUsingSQL();
        return getBags(orders);
    }

    /**
     * Get and sort Order by Priority Number and By Created_date in SQL
     */
    private List<Order> getSortedOrdersUsingSQL() {
        return orderRepository.getOrdersSortByPriorityNumberAndSortByCreateDate(BagDTO.PRIORITY_NUMBER);
    }
}
