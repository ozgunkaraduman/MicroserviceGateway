package com.migros.ucg.user_management.controller;

import com.migros.ucg.user_management.model.entity.User;
import com.migros.ucg.user_management.model.service.AbstractUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/authentication")
@RestController
public class AuthenticationController
{
    @Autowired
    private AbstractUserService userService;

    @PostMapping("sign-in")
    public ResponseEntity<String> signIn(@RequestBody User user)
    {
        String signInJWT = "";

        return new ResponseEntity<>(signInJWT, HttpStatus.OK);
    }

    @PostMapping("sign-up")
    public ResponseEntity<User> signUp(@RequestBody User user)
    {
        if(userService.findByUsername(user.getUsername()).isPresent())
        {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }
}
