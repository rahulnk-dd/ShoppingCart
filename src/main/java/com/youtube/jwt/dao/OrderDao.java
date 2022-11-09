package com.youtube.jwt.dao;

import com.youtube.jwt.entity.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrdersProduct, Integer> {
}
