package com.restfulServices.restfulServicePart1.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {
    @GetMapping(path = "/hello-world")
    public WelcomeToSpring helloWorld(){
        return new WelcomeToSpring("Welcome to spring boot");
    }
}
