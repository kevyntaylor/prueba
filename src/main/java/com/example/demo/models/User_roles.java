package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_roles")
@EntityListeners(AuditingEntityListener.class)
public class User_roles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(columnDefinition = "role_id", nullable = false)
    private Roles role_id;

    @ManyToOne
    @JoinColumn(columnDefinition = "usuario_id", nullable = false)
    private Usuarios usuario_id;
}
