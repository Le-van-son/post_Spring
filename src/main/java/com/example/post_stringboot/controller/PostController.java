package com.example.post_stringboot.controller;

import com.example.post_stringboot.model.Post;
import com.example.post_stringboot.service.PostServiceImpl;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostServiceImpl postService;
    @GetMapping("")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("posts", postService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createPost(Post post) {
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        postService.save(post);
        modelAndView.addObject("post", postService.save(post));
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView formEdit(@PathVariable int id) {
        Post post = postService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("posts", post);
        return modelAndView;
    }

    @PostMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable int id, Post post) {
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        postService.save(post);
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView deletePost(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("redirect:/posts");
        postService.remove(id);
        return modelAndView;
    }
    @GetMapping ("/search")
    public ModelAndView findName(@RequestParam String input){
        ModelAndView modelAndView = new ModelAndView("search");
        Iterable<Post> postList = postService.findAllByTitleContaining(input);
        modelAndView.addObject("posts",postList);
        return modelAndView;
    }
    @GetMapping("/top4")
    public ModelAndView top4(){
        ModelAndView modelAndView = new ModelAndView("top4");
        modelAndView.addObject("posts",postService.getTop4New());
        return modelAndView;
    }
}
