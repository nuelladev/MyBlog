package com.example.MyBlog.repositories;

import com.example.MyBlog.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
