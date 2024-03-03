package com.cuneytokankaya.fullstackapp.repository;

import com.cuneytokankaya.fullstackapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
