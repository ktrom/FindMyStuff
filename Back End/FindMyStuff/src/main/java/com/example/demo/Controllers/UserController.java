package com.example.demo.Controllers;

import com.example.demo.Controllers.exceptions.BadRequestException;
import com.example.demo.database.User;
import com.example.demo.database.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
public class UserController {
    private UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository){this.userRepository = userRepository;}

    @PostMapping("/user/createUser")
    public void createUser(@RequestBody JSONObject userData) throws JSONException {
        String username = userData.getString("username");
        String password = userData.getString("password");
        if(!userExists(username))
        {
            throw new BadRequestException();
        }
        else
        {
            userRepository.save(new User(username, password));
        }
    }
    @PostMapping("/user/login")
    public @ResponseBody
    JSONObject userLogin(@RequestBody JSONObject request) //Takes a JSONObject with fields "username" and "password", checks if user exists, if so logs the user in
    {
        //TODO
        return null;
    }
    //@RequestParam(name = "name", required = false, defaultValue = "stranger") String name
    @GetMapping("/test")
    @ResponseBody
    public JSONObject test() throws JSONException {
        JSONObject j = new JSONObject();
        j.put("name", "john");
        return j;
    }

    private boolean userExists(String username)
    {
        return !(userRepository.findByUsername(username) == null);
    }

}
