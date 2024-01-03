package com.example.MyBlog.services;

import com.example.MyBlog.models.Authority;
import com.example.MyBlog.models.User;
import com.example.MyBlog.repositories.AuthorityRepository;
import com.example.MyBlog.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    private final AuthorityRepository authorityRepository;

    public User saveUser(User user) {
        if (user.getId() == null) {
            if (user.getAuthorities().isEmpty()) {
                Set<Authority> authorities = new HashSet<>();
                authorityRepository.findById("Role_User").ifPresent(authorities::add);
                user.setAuthorities(authorities);
            }
            user.setCreatedAt(LocalDateTime.now());
        }
        user.setUpdatedAt(LocalDateTime.now());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findOneByEmail(String email) {
        return userRepository.findOneByEmailIgnoreCase(email);
    }
}
