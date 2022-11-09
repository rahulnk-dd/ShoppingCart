package com.youtube.jwt.controller;

import com.youtube.jwt.dao.ProductDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.dto.ShoppindDTO;
import com.youtube.jwt.entity.Product;
import com.youtube.jwt.entity.User;
import com.youtube.jwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping({"/forAdmin"})
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        System.out.println(productDao.findAll());
        return "This URL is only accessible to the admin";
    }

//    @GetMapping({"/forAdminProd"})
//    @PreAuthorize("hasRole('Admin')")
//    public List<Product> forAdminPro(){
//        System.out.println(productDao.findAll());
//        return productDao.findAll();
//    }

    @GetMapping({"/forUser"})
    @PreAuthorize("hasRole('User')")
    public String forUser(@RequestBody ShoppindDTO shoppindDTO){
        String userName= shoppindDTO.getUserName();
        System.out.println(userDao.findById(userName));
        return "This URL is only accessible to the user";
    }
}
