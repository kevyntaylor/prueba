package com.example.demo.repository;

import com.example.demo.models.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios,Long> {
    Usuarios findByEmailAndPassword(String email, String password);


    @Query("SELECT Usuarios FROM Usuarios JOIN User_roles ON User_roles.role_id = :role and User_roles.usuario_id = Usuarios.id")
    List<Usuarios> findByRoleUser(Long role);
}
