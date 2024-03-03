package com.cuneytokankaya.fullstackapp.repository;

import com.cuneytokankaya.fullstackapp.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findByUserId(Optional<Long> userId);
}