package com.atrify.donutQueue.repositories;

import com.atrify.donutQueue.entities.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

    @Transactional
    void deleteByClientId(Long clientId);

    Order getByClientId(Long clientId);

    @Query(
            value = "(SELECT * from orders where orders.client_id <= :PRIORITY_NUMBER Order By orders.created_date) " +
                    "union " +
                    "(SELECT * from orders where orders.client_id > :PRIORITY_NUMBER Order By orders.created_date)",
            nativeQuery = true)
    List<Order> getOrdersSortByPriorityNumberAndSortByCreateDate(@Param("PRIORITY_NUMBER") int priorityNumber);
}
