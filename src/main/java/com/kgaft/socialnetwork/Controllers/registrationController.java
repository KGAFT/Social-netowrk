package com.kgaft.socialnetwork.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class registrationController {

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    } //Comming soon

}
