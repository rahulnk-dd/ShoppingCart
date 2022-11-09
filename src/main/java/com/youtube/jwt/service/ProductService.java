package com.youtube.jwt.service;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dto.ProductDTO;
import com.youtube.jwt.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public Product addProduct(Product product){
        return productDao.save(product) ;
    }

    public ProductDTO getAllProducts(){
        List<Product> productList= productDao.findAll();
        List<String> brandList= new ArrayList<>();
        List<String> categoryList= new ArrayList<>();
        for (Product product:productList) {
            if (! brandList.contains(product.getBrand())){
                brandList.add(product.getBrand());
            }

            if(! categoryList.contains(product.getCategory())){
                categoryList.add(product.getCategory());
            }
        }
        ProductDTO productDTO= new ProductDTO(productList, brandList, categoryList);
        return productDTO;
    }

    public List<Product> addListOfProduct(List<Product> products){
        return productDao.saveAll(products);
    }

}
