package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.Product;
import com.codeup.codeupspringblog.repositories.PostsRepository;
import com.codeup.codeupspringblog.repositories.ProductsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    private PostsRepository postsDao;

    public PostController(ProductsRepository productsDao){
        this.postsDao = postsDao;
    }

    @GetMapping("/posts")
    public String getAllPost(Model model) {
//
        List<Post> posts =  postsDao.findAll();
        model.addAttribute("posts", posts);
        return "redirect:/post/index";
    }
//
//    @GetMapping("/posts/{id}")
//    public String getById(@PathVariable int id, Model model) {
//        Post post = new Post(id, "Day in the Life", "It was all good until it wasn't.");
//        model.addAttribute("post", post);
//        return "post/show";
//    }

    @GetMapping("/create")
    public String createPost() {

        postsDao.save();
        return "redirect:/posts";
    }

    @PostMapping("/posts")
    public String createPost() {
        postsDao.findAll();
        return "redirect:/";
    }
}
