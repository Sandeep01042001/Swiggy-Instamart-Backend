package com.Swaggy.Instamart.controller;

import com.Swaggy.Instamart.exceptions.InValidUserExceptions;
import com.Swaggy.Instamart.exceptions.UserNotExistException;
import com.Swaggy.Instamart.modal.User;
import com.Swaggy.Instamart.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/warehouse/admin/invite")
    public ResponseEntity wareHouseAdminInvite(@RequestParam UUID id,
                                               @RequestBody User wareHouseAdmin){
        try{
            userServices.wareHouseAdminInvite(id, wareHouseAdmin);
            return new ResponseEntity("WareHouse Admin Invited", HttpStatus.CREATED);
        }catch(InValidUserExceptions e){
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }catch (UserNotExistException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/warehouse/admin/accept/invite/{wareHouseAdminId}")
    public void acceptWareHouseAdminInvite(@PathVariable UUID wareHouseAdminId){
        userServices.acceptWareHouseAdminInvite(wareHouseAdminId);
    }

}
