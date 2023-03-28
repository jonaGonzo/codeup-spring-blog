package com.codeup.codeupspringblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProductController {

    @GetMapping("/products/create")
    public String returnProductView(){
        return "productsCreate";
    }

    @PostMapping("/products/create")
    public String insertProduct(@RequestParam String name, @RequestParam int price){
        System.out.println(name);
        System.out.println(price);
        return "productsCreate";
    }
}
