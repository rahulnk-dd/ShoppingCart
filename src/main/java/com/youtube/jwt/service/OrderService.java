package com.youtube.jwt.service;

import com.youtube.jwt.dao.OrderDao;
import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.dto.ShoppindDTO;
import com.youtube.jwt.entity.OrdersProduct;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.exception.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    public ResponseEntity<?> createOrder(@RequestBody ShoppindDTO shoppindDTO){
        String userName= shoppindDTO.getUserName();
        Optional<User> user= userDao.findById(userName);

        if(user.isPresent()){
            User userDetails =user.get();
            List<Product> listProducts= shoppindDTO.getProducts();

            for (Product product:listProducts) {
                int productId= product.getId();
                Optional<Product> productDetails=  productDao.findById(productId);
                if(productDetails.isPresent()){
                    Product product1= productDetails.get();
                    int userReqProdQua= product.getQuantities();
                    int dbProd= productDetails.get().getQuantities();
                    if(dbProd>=userReqProdQua){
                        OrdersProduct order= new OrdersProduct(product1.getProductName(), userReqProdQua, product1.getProductCost(),
                                product1.getSellingPrice(), product1.getProductImage(), product1.getBrand(), product1.getCategory());
                        userDetails.getOrders().add(order);
                        orderDao.save(order);
                        this.userDao.save(userDetails);
                    }else{
                        ErrorResponse errorResponse = new ErrorResponse();
                        errorResponse.setMessage(product1.getProductName() +" not add to cart");
                        errorResponse.setUser(userDetails);
                        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
                    }
                }else{
                    ErrorResponse errorResponse = new ErrorResponse();
                    errorResponse.setMessage(productDetails.get().getProductName()+" Product not found");
                    return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
                }
            }
            return ResponseEntity.ok(userDetails);
        }
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("User not found");
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
