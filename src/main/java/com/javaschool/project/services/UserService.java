package com.javaschool.project.services;

import com.javaschool.project.models.Order;
import com.javaschool.project.models.Product;
import com.javaschool.project.models.User;
import com.javaschool.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateUser(User update){

    }

    public void addProductToCart(User user, Product product){
        //User user = userRepository.findById(usuario.getId()).get();
        Order order = user.getOrder();
        order.addProduct(product);
        user.setOrder(order);
        userRepository.save(user);
    }

}
