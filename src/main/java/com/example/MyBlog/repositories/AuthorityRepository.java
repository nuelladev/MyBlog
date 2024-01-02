package com.example.MyBlog.repositories;

import com.example.MyBlog.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}
