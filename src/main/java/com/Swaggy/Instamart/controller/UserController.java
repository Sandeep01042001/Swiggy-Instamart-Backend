package com.Swaggy.Instamart.controller;

import com.Swaggy.Instamart.modal.User;
import com.Swaggy.Instamart.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    UserServices userServices;
    @Autowired
    public UserController(UserServices userServices){
        this.userServices = userServices;
    }

    @PostMapping("/customer/registration")
    public User customerRegistration(@RequestBody User user){
        return userServices.customerRegistration(user);
    }

    @PostMapping("/wareHouse/Admin/invite")
    public ResponseEntity wareHouseAdminInvite(@RequestParam UUID id, @RequestBody User wareHouseAdmin){

    }

}
