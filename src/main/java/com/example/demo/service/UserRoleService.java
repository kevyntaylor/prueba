package com.example.demo.service;

import com.example.demo.models.User_roles;
import com.example.demo.repository.UserRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRolRepository userRolRepository;

    public User_roles setUsr(User_roles user) {
        return userRolRepository.save(user);
    }
}
