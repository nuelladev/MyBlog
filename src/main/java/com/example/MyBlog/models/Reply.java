package com.example.MyBlog.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String replyText;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = false)
    private Comment comment;


    public Reply(Comment comment, Long userId, String replyText) {
        this.comment = comment;

        // Correct the parameter name to match the field name
        this.user = new User();
        this.user.setId(userId);

        this.replyText = replyText;
    }


}

