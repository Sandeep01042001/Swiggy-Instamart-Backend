package com.Swaggy.Instamart.service;

import com.Swaggy.Instamart.modal.User;
import jakarta.persistence.Table;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
public class MailService {

    JavaMailSender javaMailSender;
    TemplateEngine templateEngine;

    public MailService(JavaMailSender javaMailSender, TemplateEngine templateEngine){
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sandWareHouseInvitationMail(User wareHouseAdmin){

    }

}
