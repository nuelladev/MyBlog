package com.example.MyBlog.services;

import com.example.MyBlog.models.Comment;
import com.example.MyBlog.models.Reply;
import com.example.MyBlog.repositories.CommentRepository;
import com.example.MyBlog.repositories.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;
    public Reply addReply(Long commentId, Long userId, String text) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        Reply reply = new Reply(comment, userId, text);
        return replyRepository.save(reply);
    }

    public void deleteReply(Long replyId) {
        replyRepository.deleteById(replyId);
    }
}
