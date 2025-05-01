package com.example.staffsystem_C1220642;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    public String welcome(){
        return "Welcome to Spring Boot";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "Hi "+name+" welcome to my application feel free to ask help";
    }
}
