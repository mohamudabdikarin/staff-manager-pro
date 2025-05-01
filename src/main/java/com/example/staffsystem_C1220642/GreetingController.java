package com.example.staffsystem_C1220642;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URL;
import java.util.Collection;

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

//    Part two-Response entity
    @GetMapping("/success")
    public ResponseEntity<String> success() {
        return ResponseEntity.ok()
                .header("Custom-header", "Success Header")
                .body("Operation successful");
    }

    @GetMapping("/not-found")
    public ResponseEntity<String> notFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Resource not found");
    }


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody String item){
        URI location = URI.create("/created-resource/1");
        return ResponseEntity.created(location).body("resource created successfuly");

    }


}
