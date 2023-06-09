package com.example.springsecurity.services;

import com.example.springsecurity.entity.Users;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    List<Users> usersList = new ArrayList<>();

    public List<Users> getAllUser(){
        return userRepository.findAll();
    }

    public Users getUser(String username){
        return userRepository.findByUsername(username);
    }

    public Users addUser(Users users){
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        return userRepository.save(users);
    }
}
