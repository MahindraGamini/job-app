package com.mahi.job_app.service;

import com.mahi.job_app.model.User;
import com.mahi.job_app.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    private final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public User saveuser(User user){

        user.setPassword(
                encoder.encode(user.getPassword())
        );

        return userRepo.save(user);
    }
}