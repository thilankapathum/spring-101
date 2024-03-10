package dev.thilanka.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    //-- Handler method to handle helloworld request
    //-- http://localhost:3306/hello-world
    @GetMapping("hello-world")
    public String helloWorld(Model model){
        model.addAttribute("message","HelloWorld!");
        return "hello-world";
    }


}
