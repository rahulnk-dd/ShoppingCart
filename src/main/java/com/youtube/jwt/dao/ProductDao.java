package com.youtube.jwt.dao;

import com.youtube.jwt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

}
