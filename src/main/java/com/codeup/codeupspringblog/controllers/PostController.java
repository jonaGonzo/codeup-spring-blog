package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
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


    @GetMapping("/posts")
    public String getByPost(Model model) {
        List<Post> posts = new ArrayList<>(Arrays.asList(
                new Post(001, "I Died Today", "Tell me about it"),
                new Post(002, "I Lived Today", "Felt everything  about it.")));
        model.addAttribute("posts", posts);
        return "post/index";
    }

    @GetMapping("/posts/{id}")
    public String getById(@PathVariable int id, Model model) {
        Post post = new Post(id, "Day in the Life", "It was all good until it wasn't.");
        model.addAttribute("post", post);
        return "post/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createdPost() {
        return "view the form for creating a post";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "create a new post";
    }
}
