package com.example.MyBlog.services;

import com.example.MyBlog.models.Comment;
import com.example.MyBlog.models.reactor;
import com.example.MyBlog.models.Post;
import com.example.MyBlog.repositories.CommentRepository;
import com.example.MyBlog.repositories.reactorRepository;
import com.example.MyBlog.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@RequiredArgsConstructor
@Component
public class reactorService {
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final reactorRepository likeRepository;

    public void likePost(Long postId, Long userId){
        Post post =  postRepository.findById(postId).orElseThrow(() -> new RuntimeException("post not found"));
        reactor like = new reactor(post, userId);
        likeRepository.save(like);
    }
    public void unlikePost(Long likeId) {
        likeRepository.deleteById(likeId);
    }

    public void likeComment(Long commentId, Long userId) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(() -> new RuntimeException("Comment not found"));
        reactor like = new reactor(comment, userId);
        likeRepository.save(like);
    }

    public void unlikeComment(Long likeId) {
        likeRepository.deleteById(likeId);
    }

}
