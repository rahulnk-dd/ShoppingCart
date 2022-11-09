package com.youtube.jwt;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtYoutubeApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productRepository;

    @Override
    public void run(String... args) throws Exception {
        Product product= new Product();
        product.setProductName("Hair");
        product.setProductCost(200);
        product.setSellingPrice(150);
        product.setProductImage("HairImage");
        product.setQuantities(5);
        product.setBrand("Nature's");
        product.setCategory("face cream");

        Product product2= new Product();
        product2.setProductName("face cream");
        product2.setQuantities(4);
        product2.setProductCost(200);
        product2.setSellingPrice(150);
        product2.setProductImage("FaceCreamImage");
        product2.setBrand("Raja");
        product2.setCategory("Hair cream");

        productRepository.save(product);
        productRepository.save(product2);
    }

    public static void main(String[] args) {
        SpringApplication.run(JwtYoutubeApplication.class, args);
    }

}
