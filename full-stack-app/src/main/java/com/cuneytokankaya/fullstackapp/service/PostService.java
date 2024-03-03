package com.cuneytokankaya.fullstackapp.service;


import com.cuneytokankaya.fullstackapp.model.Post;
import com.cuneytokankaya.fullstackapp.model.User;
import com.cuneytokankaya.fullstackapp.repository.PostRepository;
import com.cuneytokankaya.fullstackapp.request.RequestCreatePost;
import com.cuneytokankaya.fullstackapp.request.RequestUpdatePost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService
{
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    public List<Post> getAllPosts(Optional<Long> userId)
    {
        if(userId.isPresent())
        {
            return postRepository.findByUserId(userId);
        }

        return postRepository.findAll();
    }

    public Post getPostById(Long postId)
    {
        //TODO : custom exception
        Optional<Post> post = postRepository.findById(postId);
        return post.isPresent() ? post.get() : null;
    }

    public Post save(Post post)
    {
        return postRepository.save(post);
    }

    public Post createPost(RequestCreatePost requestCreatePost)
    {
        User user = userService.getUserById(requestCreatePost.getUserId());
        if(user == null)
        {
            //TODO : custom exception
            return null;
        }

        Post newPost = new Post();
        newPost.setTitle(requestCreatePost.getTitle());
        newPost.setText(requestCreatePost.getText());
        newPost.setUser(user);

        return postRepository.save(newPost);
    }

    public Post updatePost(Long postId, RequestUpdatePost requestUpdatePost)
    {
        Optional<Post> post = postRepository.findById(postId);
        if(post.isPresent())
        {
            Post updatePost = post.get();
            updatePost.setText(requestUpdatePost.getText());
            updatePost.setTitle(requestUpdatePost.getTitle());
            postRepository.save(updatePost);
        }
        return null;
    }

    public void deletePost(Long postId)
    {
        postRepository.deleteById(postId);
    }
}
