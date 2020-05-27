package com.example.demo.Services;

import com.example.demo.database.User;
import com.example.demo.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {

        Iterable<User> it = userRepository.findAll();

        ArrayList<User> users = new ArrayList<User>();
        it.forEach(e -> users.add(e));

        return users;
    }

    public Long count() {

        return userRepository.count();
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }

    public void addNewUser(String username, String password)
    {
        User u = new User(username, password);
        userRepository.save(u);
    }

}
