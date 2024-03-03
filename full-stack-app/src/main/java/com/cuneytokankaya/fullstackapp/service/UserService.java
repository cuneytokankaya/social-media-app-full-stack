package com.cuneytokankaya.fullstackapp.service;

import com.cuneytokankaya.fullstackapp.model.User;
import com.cuneytokankaya.fullstackapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User save(User user)
    {
        return userRepository.save(user);
    }

    public User getUserById(Long userId)
    {
        //TODO : custom exception
        Optional<User> user = userRepository.findById(userId);
        return user.isPresent() ? user.get() : null;
    }

    public User update(Long userId, User user)
    {
        Optional<User> userFromDb = userRepository.findById(userId);
        if(userFromDb.isPresent())
        {
            User updatedUser = userFromDb.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setPassword(user.getPassword());
            userRepository.save(updatedUser);
        }
        return null;
    }

    public void delete(Long userId)
    {
        userRepository.deleteById(userId);
    }
}
