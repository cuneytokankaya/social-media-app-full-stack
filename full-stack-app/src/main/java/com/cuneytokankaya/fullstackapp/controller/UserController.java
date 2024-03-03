package com.cuneytokankaya.fullstackapp.controller;

import com.cuneytokankaya.fullstackapp.model.User;
import com.cuneytokankaya.fullstackapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user)
    {
        return userService.save(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId)
    {
        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user)
    {
        return userService.update(userId,user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable Long userId)
    {
        userService.delete(userId);
    }
}
