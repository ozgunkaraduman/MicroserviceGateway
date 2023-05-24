package com.migros.ucg.user_management.model.service;

import com.migros.ucg.user_management.model.entity.User;
import com.migros.ucg.user_management.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public abstract class AbstractUserService implements EntityService<User, Integer>
{
    @Autowired
    protected PasswordEncoder passwordEncoder;

    @Autowired
    protected UserRepository userRepository;

    public abstract Optional<User> findByUsername(String username);
}
