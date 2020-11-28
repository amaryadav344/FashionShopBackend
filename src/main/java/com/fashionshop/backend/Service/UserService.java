package com.fashionshop.backend.Service;

import com.fashionshop.backend.DTO.User;
import com.fashionshop.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        String encodedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.saveAndFlush(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public User find(String userName) {
        return userRepository.findOneByUsername(userName);
    }

    public User find(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
