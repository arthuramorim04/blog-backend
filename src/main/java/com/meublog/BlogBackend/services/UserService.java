package com.meublog.BlogBackend.services;

import com.meublog.BlogBackend.entities.User;
import com.meublog.BlogBackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(new User());
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
