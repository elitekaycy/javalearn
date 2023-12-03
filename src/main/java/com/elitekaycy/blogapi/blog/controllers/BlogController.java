package com.elitekaycy.blogapi.blog.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.elitekaycy.blogapi.blog.Dtos.BlogDto;
import com.elitekaycy.blogapi.blog.models.Blogs;
import com.elitekaycy.blogapi.blog.services.BlogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/user/{userId}")
    public ResponseEntity<Blogs> createBlog(@RequestBody BlogDto blog, @PathVariable Long userId) {
        return ResponseEntity.ok(blogService.createNewBlog(blog, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogs> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Blogs>> getAllBlogs(@PathVariable Long userId) {
        return ResponseEntity.ok(blogService.listAllBlogsByUser(userId));
    }
}
