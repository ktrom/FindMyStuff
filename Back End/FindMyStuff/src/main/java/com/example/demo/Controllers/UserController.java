package com.example.demo.Controllers;

import com.example.demo.Controllers.exceptions.BadRequestException;
import com.example.demo.Services.UserService;
import com.example.demo.database.User;
import com.example.demo.database.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> allUsers() {

        return userService.findAll();
    }

    @GetMapping("/users/count")
    public Long count() {
        return userService.count();
    }

    @DeleteMapping("/users/{id}")
    public void delete(@PathVariable String id) {

        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
    }

    @PostMapping("/users/create")
    public void createUser(@RequestParam String username, @RequestParam String password)
    {
        userService.addNewUser(username, password);
    }
}
