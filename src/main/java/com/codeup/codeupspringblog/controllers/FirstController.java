package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FirstController {

    @GetMapping("/hello")
    @ResponseBody
    public String returnHelloWorld(){
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/jona")
    @ResponseBody
    public String returnJona(){
        return "<h1> Big Zaddy Jona!</h1>";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String  greetName(@PathVariable String name){
        return "Hello " + name + "!";
    }

    @GetMapping("/hello-world")
    @ResponseBody
    public String returnHelloWorld(@RequestParam(defaultValue = "true") boolean uppercase) {
        if (uppercase) {

            return "HELLO ZENITH";
        }else {
            return "Hello Zenith";
        }
    }

}

