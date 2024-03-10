package dev.thilanka.thymeleaf.controller;

import dev.thilanka.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    //-- Handler Method to handle Variable Expression request
    @GetMapping("variable-expression")
    public String variableExpression(Model model){
        User user = new User("Ramesh","ramesh@gmail.com","ADMIN", "Male");
        model.addAttribute("user",user);
        return "variable-expression";   //-- returning View Name (html file needs to be created)
    }

    @GetMapping("selection-expression")
    public String selectionExpression(Model model){
        User user = new User("Ramesh","ramesh@gmail.com","ADMIN","Male");
        model.addAttribute("user",user);
        return "selection-expression";
    }
}
