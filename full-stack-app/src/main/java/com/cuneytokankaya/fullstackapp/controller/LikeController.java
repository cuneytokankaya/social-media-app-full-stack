package com.cuneytokankaya.fullstackapp.controller;

import com.cuneytokankaya.fullstackapp.model.Like;
import com.cuneytokankaya.fullstackapp.request.RequestCreateLike;
import com.cuneytokankaya.fullstackapp.request.RequestUpdateLike;
import com.cuneytokankaya.fullstackapp.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @GetMapping
    public List<Like> getAllLikes(@RequestParam Optional<Long> userId,
                                     @RequestParam Optional<Long> postId){
        return likeService.getAllLikes(userId,postId);
    }

    @GetMapping("/{likeId}")
    public Like getLikeById(@PathVariable Long likeId)
    {
        return likeService.getLikeById(likeId);
    }

    @PostMapping
    public Like createLike(@RequestBody RequestCreateLike requestCreateLike)
    {
        return likeService.createLike(requestCreateLike);
    }

    @PutMapping("/{likeId}")
    public Like updateLike(@PathVariable Long likeId, @RequestBody RequestUpdateLike requestUpdateLike)
    {
        return likeService.updateLike(likeId,requestUpdateLike);
    }

    @DeleteMapping("/{likeId}")
    public void deleteLike(@PathVariable Long likeId)
    {
        likeService.deleteLike(likeId);
    }

}
