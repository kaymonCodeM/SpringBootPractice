package com.secure.SecurityDemo.Service;

import com.secure.SecurityDemo.Dao.UserDao;
import com.secure.SecurityDemo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MyUserDetailsServiceImp implements MyUserDetailsService {

    @Autowired
    UserDao userDao;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Override
    public List<User> findAllUsers() {
        return this.userDao.findAll();
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> user = this.userDao.findById(userId);
        if(user.isPresent()){
            return user.get();
        }else {
            throw new RuntimeException("UserId not found: " + userId);
        }
    }

    @Override
    public User addUser(User user) {
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        return userDao.save(user);
    }

    @Override
    public User updateUser(User user) {
        String passwordEncode = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncode);
        return userDao.save(user);
    }

    @Override
    public String deleteUser(int userId) {
        this.userDao.deleteById(userId);
        return "User Deleted by Id: " + userId;
    }

    @Override
    public PasswordEncoder getEncoder() {
        return this.passwordEncoder;
    }
}
