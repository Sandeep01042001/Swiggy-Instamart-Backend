package com.Swaggy.Instamart.service;


import com.Swaggy.Instamart.exceptions.UserNotExistException;
import com.Swaggy.Instamart.service.MailService;
import com.Swaggy.Instamart.modal.User;
import com.Swaggy.Instamart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServices {

    UserRepository userRepository;
    MailService mailService;
    @Autowired
    public UserServices(UserRepository userRepository, MailService mailService){
        this.userRepository = userRepository;
        this.mailService = mailService;

    }

    public User customerRegistration(User user){
        return this.userRepository.save(user);
    }

    public User wareHouseAdminInvite(UUID id, User wareHouseAdmin){
        User admin = userRepository.findById(id).orElse(null);
        if(admin == null){
            throw new UserNotExistException("user with id does not exist");
        }
        if(!admin.getRole().equals("APP_ADMIN")){
            throw new UserNotExistException("User is not allow to invate wareHouse Admin");
        }
        wareHouseAdmin.setStatus("INACTIVE");
        wareHouseAdmin = userRepository.save(wareHouseAdmin);
        mailService.sendWareHouseInvitationMail(wareHouseAdmin);
        return wareHouseAdmin;
    }

    public void acceptWareHouseAdminInvite(UUID wareHouseAdminId){
        User user =  userRepository.findById(wareHouseAdminId).orElse(null);
        user.setStatus("ACTIVE");
        userRepository.save(user);
    }
}
