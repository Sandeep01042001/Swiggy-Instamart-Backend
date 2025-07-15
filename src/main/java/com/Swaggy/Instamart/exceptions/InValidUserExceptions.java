package com.Swaggy.Instamart.exceptions;

import com.Swaggy.Instamart.modal.User;

public class InValidUserExceptions extends RuntimeException{
    public InValidUserExceptions(String message){
        super(message);
    }
}
