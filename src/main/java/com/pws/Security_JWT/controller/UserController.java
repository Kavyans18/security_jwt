package com.pws.Security_JWT.controller;

import com.pws.Security_JWT.entity.User;
import com.pws.Security_JWT.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImp service;


    @PostMapping("/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        service.saveUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int id) {
        service.updateUser(user, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User us = service.getUserById(id);
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> us = service.getAll();
        return new ResponseEntity<>(us, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id) {
        service.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

