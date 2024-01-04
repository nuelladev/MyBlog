package com.example.MyBlog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
public class reactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private Comment comment;

    public reactor(Comment comment, Long userId) {
        this.comment = comment;
        this.user = new User();
        this.user.setId(userId);
    }

    public reactor(Post post, Long userId) {
        this.user = new User();
        this.user.setId(userId);
    }
}
