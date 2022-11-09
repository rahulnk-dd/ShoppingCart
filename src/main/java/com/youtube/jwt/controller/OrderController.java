package com.youtube.jwt.controller;


import com.youtube.jwt.dao.OrderDao;
import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.dto.ShoppindDTO;
import com.youtube.jwt.entity.OrdersProduct;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping({"/addCart"})
    @PreAuthorize("hasRole('User')")
    public ResponseEntity<?> forUserOrder(@RequestBody ShoppindDTO shoppindDTO){
        return orderService.createOrder(shoppindDTO);

    }

}
