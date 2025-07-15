package com.Swaggy.Instamart.service;


import com.Swaggy.Instamart.exceptions.UserNotExistException;
import com.Swaggy.Instamart.modal.User;
import com.Swaggy.Instamart.repository.UserRepository;
import jakarta.websocket.server.ServerEndpoint;
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
            throw new UserNotExistException(String.format("user with id %s does not exist", id.toString()));
        }
        if(!admin.getRole().equals("AppAdmin")){
            throw new UserNotExistException("User is not allow to invate wareHouse Admin");
        }
        wareHouseAdmin.setStatus("INACTIVE");
        wareHouseAdmin = userRepository.save(wareHouseAdmin);
        mailService.sandWareHouseInvitationMail(wareHouseAdmin);

    }
}
