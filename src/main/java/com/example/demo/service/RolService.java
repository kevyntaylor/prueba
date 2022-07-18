package com.example.demo.service;

import com.example.demo.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {
    @Autowired
    private UserRoleRepository userRoleRepository;

    public List<String> getRoles(Long userId) {
        try{
            return userRoleRepository.getRoles(userId);
        }catch (RuntimeException e){
            return null;
        }
    }
}
