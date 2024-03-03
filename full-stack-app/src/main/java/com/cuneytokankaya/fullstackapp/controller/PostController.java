package com.cuneytokankaya.fullstackapp.controller;

import com.cuneytokankaya.fullstackapp.model.Post;
import com.cuneytokankaya.fullstackapp.request.RequestCreatePost;
import com.cuneytokankaya.fullstackapp.request.RequestUpdatePost;
import com.cuneytokankaya.fullstackapp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId)
    {
        return postService.getAllPosts(userId);
    }

    @GetMapping("/{postId}")
    public Post getPostById(@PathVariable Long postId)
    {
        return postService.getPostById(postId);
    }

    @PostMapping
    public Post createPost(@RequestBody RequestCreatePost requestCreatePost)
    {
        return postService.createPost(requestCreatePost);
    }

    @PutMapping("/{postId}")
    private Post updatePost(@PathVariable Long postId, @RequestBody RequestUpdatePost requestUpdatePost)
    {
        return postService.updatePost(postId,requestUpdatePost);
    }

    @DeleteMapping("/{postId}")
    private void deletePost(@PathVariable Long postId)
    {
        postService.deletePost(postId);
    }
}
