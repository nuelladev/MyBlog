package com.example.MyBlog.repositories;

import com.example.MyBlog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
