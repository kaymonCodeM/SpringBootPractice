package com.secure.SecurityDemo.Service;

import com.secure.SecurityDemo.Entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public interface MyUserDetailsService{
    List<User> findAllUsers();
    User getUserById(int userId);
    User addUser(User user);
    User updateUser(User user);
    String deleteUser(int userId);

    PasswordEncoder getEncoder();
}
