package com.elitekaycy.blogapi.blog.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.elitekaycy.blogapi.blog.Dtos.CommentDto;
import com.elitekaycy.blogapi.blog.Repository.CommentRepository;
import com.elitekaycy.blogapi.blog.models.Comments;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comments createComment(CommentDto comment, Long blogId, Long userId) {
        Comments com = new Comments();
        com.setComment(comment.getComment());
        com.setBlogId(blogId);
        com.setUserId(userId);
        com.setCreatedAt(LocalDateTime.now());

        commentRepository.save(com);
        return com;
    }

    public List<Comments> findCommentByUserId(Long userId) {
        return commentRepository.findAllCommentsByUserId(userId);
    }

    public List<Comments> findCommentByBlogId(Long blogId) {
        return commentRepository.findAllByBlogId(blogId);
    }

    public Optional<Comments> findById(Long CommentId) {
        return commentRepository.findById(CommentId);
    }


}
