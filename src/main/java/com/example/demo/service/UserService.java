package com.example.demo.service;

import com.example.demo.models.Usuarios;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuarios getUsr(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email,password);
    }

    public Usuarios setUsr(Usuarios usuarios) {
        return usuarioRepository.save(usuarios);
    }


    public List<Usuarios> findAll() {
        return usuarioRepository.findAll();
    }

    public List<Usuarios> getclients(Long role) {
        return usuarioRepository.findByRoleUser(role);
    }
}
