package com.youtube.jwt.controller;



import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dto.ProductDTO;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping({"/getAllProducts"})
    @PreAuthorize("hasRole('Admin') or hasRole('User')")
    public ProductDTO forAdminPro(){
        return productService.getAllProducts();
    }

    @PostMapping({"/addProduct"})
    @PreAuthorize("hasRole('Admin')")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @PostMapping({"/addListOfProduct"})
    @PreAuthorize("hasRole('Admin')")
    public List<Product> addListOfProduct(@RequestBody List<Product> products){
        return productService.addListOfProduct(products);
    }

}
