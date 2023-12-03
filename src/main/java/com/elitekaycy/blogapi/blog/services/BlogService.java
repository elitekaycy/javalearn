package com.elitekaycy.blogapi.blog.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.elitekaycy.blogapi.blog.Dtos.BlogDto;
import com.elitekaycy.blogapi.blog.Repository.BlogRepository;
import com.elitekaycy.blogapi.blog.Repository.UserRepository;
import com.elitekaycy.blogapi.blog.models.Blogs;
import com.elitekaycy.blogapi.blog.models.Users;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;

    public Blogs createNewBlog(BlogDto blog, Long userId) {
        Users user = userRepository.findById(userId).orElseThrow();
        Blogs newBlog = new Blogs();

        newBlog.setTitle(blog.getTitle());
        newBlog.setContent(blog.getContent());
        newBlog.setCreatedAt(LocalDateTime.now());
        newBlog.setAuthor(user);

        blogRepository.save(newBlog);
        return newBlog;
    }

    public List<Blogs> listAllBlogsByUser(Long userId) {
        return blogRepository.findAllByAuthorId(userId);
    }

    public Blogs getBlogById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow();
    }

    public Boolean deleteBlog(Long blogId) {
        if(blogRepository.existsById(blogId)) {
            return false;
        }

        blogRepository.deleteById(blogId);
        return true;

    }
    
}
