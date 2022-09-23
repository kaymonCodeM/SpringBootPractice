package com.secure.SecurityDemo.controller;

import com.secure.SecurityDemo.Entity.User;
import com.secure.SecurityDemo.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HomeController {

    @Autowired
    MyUserDetailsService userDetailsService;

    @GetMapping()
    public String home(){
        return "<h1>Hello World!</h1>";
    }

    @GetMapping("/user")
    public String user(){
        return "<h1>Hello User<h2>";
    }

    @GetMapping("/admin")
    public String admin(){
        return "<h1>Hello Admin!</h1>";
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return this.userDetailsService.findAllUsers();
    }

    @GetMapping("/users/{userID}")
    public User getUser(@PathVariable String userID){
        return this.userDetailsService.getUserById(Integer.parseInt(userID));
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return this.userDetailsService.addUser(user);
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user){
        return this.userDetailsService.updateUser(user);
    }

    @DeleteMapping("/users/{userID}")
    public String deleteUser(@PathVariable String userID){
        return this.userDetailsService.deleteUser(Integer.parseInt(userID));
    }
}
