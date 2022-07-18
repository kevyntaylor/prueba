package com.example.demo.repository;

import com.example.demo.models.User_roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolRepository extends JpaRepository<User_roles,Long> {
}
