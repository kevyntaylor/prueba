package com.example.demo.repository;

import com.example.demo.models.User_roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<User_roles,Long> {
    @Query(value = "select r.rol from user_roles ur JOIN roles r ON r.id = ur.role_id_id WHERE ur.usuario_id_id = :userId", nativeQuery = true)
    public List<String> getRoles(Long userId);
}
