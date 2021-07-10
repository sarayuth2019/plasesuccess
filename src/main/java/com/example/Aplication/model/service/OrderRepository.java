package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order>findByNameOrder(String nameOrder);
    List<Order>findByUserId(int userId);
    List<Order>findByCustomerId(int customerId);
    List<Order> findByStatusAndUserId(int status,int userId);
}
