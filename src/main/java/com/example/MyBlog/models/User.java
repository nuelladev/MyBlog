package com.example.MyBlog.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    @JsonIgnore
    private String password;

   private String firstName;

    private String lastName;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Post> posts;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_authority",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
    Set<Authority> authorities = new HashSet<>();
}
