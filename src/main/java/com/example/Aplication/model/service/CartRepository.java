package com.example.Aplication.model.service;
import com.example.Aplication.model.table.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public interface CartRepository extends JpaRepository<Cart,Integer> {
    List<Cart> findByNameCart(String nameCart);
    List<Cart>findByUserId(int userId);
    List<Cart>findByCustomerId(int customerId);

}




