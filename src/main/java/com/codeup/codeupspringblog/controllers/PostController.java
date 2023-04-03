package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;

import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String getAllPost(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "post/index";
    }


    @GetMapping("/posts/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Post editedPost = postsDao.findById(id).get();
        model.addAttribute("post", editedPost);
        return "post/show";
    }
    @PostMapping("posts/{id}/edit")
    public String editPost(@ModelAttribute Post post, @PathVariable Long id){
        Post editedPost = postsDao.findById(id).get();
        editedPost.setTitle(post.getTitle());
        editedPost.setBody(post.getBody());
        postsDao.save(editedPost);
        return "redirect:/posts";
    }


    @GetMapping("/post/create")
    public String returnPostCreateForm(Model model){
        model.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    public String createPost(@RequestParam String title, @RequestParam String body) {
        Post post = new Post(title, body);
        User user = usersDao.findById(1L).get();
        post.setUser(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/post/edit")
    public String editPost(){
        Post editedPost = new Post(1L, "Updated Title", "Updated Body");
        postsDao.save(editedPost);
        return "redirect:/posts";
    }

}
