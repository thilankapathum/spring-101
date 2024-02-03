package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller //-- Use the class as a Spring MVC Controller
//@ResponseBody   //-- Convert Java Object to JSON (tells controller that the object returned is automatically serialized to JSON and passed back to HTTPResponse Object)

@RestController //-- Combination of @Controller & @ResponseBody annotations.
public class HelloWorldController {

    //-- HTTP GET Request
    //-- http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World!";
    }

    //-- @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
}
