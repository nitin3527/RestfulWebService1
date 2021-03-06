package com.restfulServices.restfulServicePart1.hello;

public class WelcomeToSpring {
    private String message;
    WelcomeToSpring(String msg){
        this.message = msg;
    }

    public String getMessage() {
        return message;
    }
}
