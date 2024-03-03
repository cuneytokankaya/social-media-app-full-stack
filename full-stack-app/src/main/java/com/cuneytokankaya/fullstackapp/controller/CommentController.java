package com.cuneytokankaya.fullstackapp.controller;

import com.cuneytokankaya.fullstackapp.model.Comment;
import com.cuneytokankaya.fullstackapp.request.RequestCreateComment;
import com.cuneytokankaya.fullstackapp.request.RequestUpdateComment;
import com.cuneytokankaya.fullstackapp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@RequestParam Optional<Long> userId,
                                        @RequestParam Optional<Long> postId){
        return commentService.getAllComments(userId,postId);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Long commentId)
    {
        return commentService.getCommentById(commentId);
    }

    @PostMapping
    public Comment createComment(@RequestBody RequestCreateComment requestCreateComment)
    {
        return commentService.createComment(requestCreateComment);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody RequestUpdateComment requestUpdateComment)
    {
        return commentService.updateComment(commentId,requestUpdateComment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId)
    {
        commentService.deleteComment(commentId);
    }

}
