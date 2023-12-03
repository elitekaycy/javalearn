package com.elitekaycy.blogapi.blog.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elitekaycy.blogapi.blog.models.Blogs;

@Repository
public interface BlogRepository extends JpaRepository<Blogs, Long> {

    List<Blogs> findAllByAuthorId(Long userId);
}
