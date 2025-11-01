package com.Saloonsystem.User.Service.controller;

import com.Saloonsystem.User.Service.model.User;
import com.Saloonsystem.User.Service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createduser = userService.createuser(user);
        return new ResponseEntity<>(createduser, HttpStatus.CREATED);
    }

    @GetMapping("/api/allusers")
    public ResponseEntity<List<User> >getUsers(){
        List<User> users = userService.getAllusers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(("/api/users/{id}"))
    public ResponseEntity<User> getUserbyId(@PathVariable Long id) throws Exception {
       User user= userService.getUserByTd(id);
       return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        User updateduser= userService.updateUser(id, user);
        return new ResponseEntity<>(updateduser, HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
        userService.deleteuser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.ACCEPTED);
    }

}
