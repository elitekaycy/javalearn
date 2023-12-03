package com.elitekaycy.blogapi.blog.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elitekaycy.blogapi.blog.Dtos.CommentDto;
import com.elitekaycy.blogapi.blog.models.Comments;
import com.elitekaycy.blogapi.blog.services.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{userId}/{blogId}")
    public ResponseEntity<Comments> postComment(@RequestBody CommentDto comment, @PathVariable Long blogId, @PathVariable Long userId) {
        return ResponseEntity.ok(commentService.createComment(comment, blogId, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Comments>> getAllCommentsByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(commentService.findCommentByUserId(userId));
    }

    @GetMapping("/blog/{blogId}")
    public ResponseEntity<List<Comments>> getAllCommentByBlog(@PathVariable Long blogId) {
        return ResponseEntity.ok(commentService.findCommentByBlogId(blogId));
    }
}
