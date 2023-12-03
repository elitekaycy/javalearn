package com.elitekaycy.blogapi.blog.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elitekaycy.blogapi.blog.models.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Long> {

    /*
     * 
     * comment on a blog
     * get all comments
     * get all comments on a blog
     * get all comments from a user
     * get all comments on a comment
     */

     List<Comments> findAllCommentsByUserId(Long userId);
     List<Comments> findAllByBlogId(Long blogId);
}
