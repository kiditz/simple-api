package com.homecredit.test.controller;

import com.homecredit.test.entity.User;
import com.homecredit.test.entity.model.Modules;
import com.homecredit.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/modules")
    public Modules getModules(@RequestParam("UserId") int userId) {
        return userService.getModules(userId);
    }

    @PostMapping("/users")
    public List<User> addNewUser(@RequestBody List<User> user) {
        return userService.saveAllUser(user);
    }

    @DeleteMapping("/users")
    public void deleteUsers() {
        userService.deleteAll();
    }
}
