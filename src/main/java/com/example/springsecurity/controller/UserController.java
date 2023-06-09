package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseBody
    public List<Users> getAllUsers(){
        return userService.getAllUser();
    }

    @GetMapping("/{username}")
//    @PreAuthorize("hasRole('ADMIN')")
    public Users getUser(@PathVariable ("username") String username){
        return userService.getUser(username);
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody Users users){
        if(users.getUsername() != null){
            userService.addUser(users);
            return "User Added";
        }
        return "Operation Failed";
    }
}
