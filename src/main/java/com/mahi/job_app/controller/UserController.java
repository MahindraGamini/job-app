package com.mahi.job_app.controller;

import com.mahi.job_app.model.User;
import com.mahi.job_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public void register(@RequestBody User user) {

        userService.saveuser(user);
    }

}
