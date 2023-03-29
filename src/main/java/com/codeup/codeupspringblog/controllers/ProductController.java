package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Product;
import com.codeup.codeupspringblog.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ProductController {
    private ProductsRepository productsDao;

    public ProductController(ProductsRepository productsDao){
        this.productsDao = productsDao;
    }

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

    @GetMapping("/delete/product")
    public String deleteProduct(){
        productsDao.deleteById(1L);
        return "redirect:/products";
    }

    @GetMapping("create/products")
    public String createProduct(){
        Product product = new Product("Farm", 50000000);
        productsDao.save(product);
        return "redirect:/products";
    }
}
