package com.example.blogapp.controllers;

import com.example.blogapp.models.Post;
import com.example.blogapp.services.FileService;
import com.example.blogapp.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PostService postService;
    private final FileService fileService;

    @GetMapping("/")
    public String home(Model model) {
        List<Post> posts = postService.getAll();
        model.addAttribute("posts", posts);
        return "home";
    }

    @GetMapping("/images/{imageUri}")
    @ResponseBody
    public Resource getImage(@PathVariable String imageUri) {
        return fileService.load(imageUri);
    }
}