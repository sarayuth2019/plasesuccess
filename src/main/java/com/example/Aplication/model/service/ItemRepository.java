package com.example.Aplication.model.service;

import com.example.Aplication.model.table.Cart;
import com.example.Aplication.model.table.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Items,Integer> {
    Optional<Items> findById(int id);
    List<Cart> findByName(String name);
    List<Cart>findByUser(int user);
}
