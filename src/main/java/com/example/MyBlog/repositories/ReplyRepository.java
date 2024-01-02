package com.example.MyBlog.repositories;

import com.example.MyBlog.models.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
