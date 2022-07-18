package com.example.demo.controller;

import com.example.demo.models.Usuarios;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioRestController {

    private final UserService service;

    @Autowired
    public UsuarioRestController(UserService service) {
        this.service = service;
    }

    @GetMapping("user")
    public List<Usuarios> AllUsers() {
        List<Usuarios> users = service.findAll();
        return users;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_EJECUTIVO')")
    @PostMapping("clients-list")
    public List<Usuarios> getClients(@RequestBody Long rol) {
        List<Usuarios> users = service.getclients(rol);
        return users;
    }

    @PostMapping(value = "user")
    public Usuarios saveUsr(@RequestBody Usuarios usuarios) {
        Usuarios users = service.setUsr(usuarios);
        return users;
    }
}
