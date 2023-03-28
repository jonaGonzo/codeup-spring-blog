package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HtmlController {

    @GetMapping("/howdy")
    public String returnHowdy(){
        return "hello";
    }
}
