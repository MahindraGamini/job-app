package com.mahi.job_app.service;

import com.mahi.job_app.model.User;
import com.mahi.job_app.model.UserPrinciple;
import com.mahi.job_app.repo.UserRepo;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
    private UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(@NonNull String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if(user==null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException(username);

        }
        return new UserPrinciple(user);
    }
}
