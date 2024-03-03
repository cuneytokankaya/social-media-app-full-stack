package com.cuneytokankaya.fullstackapp.service;

import com.cuneytokankaya.fullstackapp.model.Like;
import com.cuneytokankaya.fullstackapp.model.Post;
import com.cuneytokankaya.fullstackapp.model.User;
import com.cuneytokankaya.fullstackapp.repository.LikeRepository;
import com.cuneytokankaya.fullstackapp.request.RequestCreateLike;
import com.cuneytokankaya.fullstackapp.request.RequestUpdateLike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    public List<Like> getAllLikes(Optional<Long> userId, Optional<Long> postId)
    {
        if(userId.isPresent() && postId.isPresent())
        {
            return likeRepository.findByUserIdAndPostId(userId.get(),postId.get());
        }else if (userId.isPresent())
        {
            return likeRepository.findByUserId(userId.get());
        }else if (postId.isPresent())
        {
            return likeRepository.findByPostId(postId.get());
        }

        return likeRepository.findAll();
    }

    public Like getLikeById(Long likeId)
    {
        return likeRepository.findById(likeId).orElse(null);
    }

    public Like createLike(RequestCreateLike requestCreateLike)
    {
        User user = userService.getUserById(requestCreateLike.getUserId());
        Post post = postService.getPostById(requestCreateLike.getPostId());

        if(user != null && post != null)
        {
            Like newLike= new Like();
            newLike.setUser(user);
            newLike.setPost(post);
            return likeRepository.save(newLike);
        }
        return null;
    }

    public Like updateLike(Long likeId, RequestUpdateLike requestUpdateLike)
    {
        Optional<Like> likeFromDb = likeRepository.findById(likeId);
        if(likeFromDb.isPresent())
        {
            Like updatedLike = likeFromDb.get();
            //updatedLike.setText(comment.getText());
            return likeRepository.save(updatedLike);
        }
        return null;
    }

    public void deleteLike(Long likeId)
    {
        likeRepository.deleteById(likeId);
    }
}
