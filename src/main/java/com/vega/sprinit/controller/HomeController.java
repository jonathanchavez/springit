package com.vega.sprinit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//@ResponseBody //method return values to be bound to web response body, knows how to handle web
@RestController
public class HomeController {

    @RequestMapping("/")//way to tell spring that this method is going to accept request on a path http path
    public String home(){
        return "ASD";
    }

}
