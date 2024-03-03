package com.cuneytokankaya.fullstackapp.service;

import com.cuneytokankaya.fullstackapp.model.Comment;
import com.cuneytokankaya.fullstackapp.model.Post;
import com.cuneytokankaya.fullstackapp.model.User;
import com.cuneytokankaya.fullstackapp.repository.CommentRepository;
import com.cuneytokankaya.fullstackapp.request.RequestCreateComment;
import com.cuneytokankaya.fullstackapp.request.RequestUpdateComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    public List<Comment> getAllComments(Optional<Long> userId, Optional<Long> postId)
    {
        if(userId.isPresent() && postId.isPresent())
        {
            return commentRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if (userId.isPresent())
        {
            return commentRepository.findByUserId(userId.get());
        }else if (postId.isPresent())
        {
            return commentRepository.findByPostId(postId.get());
        }

        return commentRepository.findAll();
    }

    public Comment getCommentById(Long commentId)
    {
        return commentRepository.findById(commentId).orElse(null);
    }

    public Comment createComment(RequestCreateComment requestCreateComment)
    {
        User user = userService.getUserById(requestCreateComment.getUserId());
        Post post = postService.getPostById(requestCreateComment.getPostId());

        if(user != null && post != null)
        {
            Comment newComment = new Comment();
            newComment.setUser(user);
            newComment.setPost(post);
            newComment.setText(requestCreateComment.getText());
            return commentRepository.save(newComment);
        }
        return null;
    }

    public Comment updateComment(Long commentId, RequestUpdateComment requestUpdateComment)
    {
        Optional<Comment> commentFromDb = commentRepository.findById(commentId);
        if(commentFromDb.isPresent())
        {
            Comment updatedComment = commentFromDb.get();
            updatedComment.setText(requestUpdateComment.getText());
            return commentRepository.save(updatedComment);
        }
        return null;
    }

    public void deleteComment(Long commentId)
    {
        commentRepository.deleteById(commentId);
    }
}
