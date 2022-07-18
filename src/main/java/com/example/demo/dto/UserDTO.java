package com.example.demo.dto;

public class UserDTO {
    private Long Id;
    private String user;
    private String email;
    private String ubication;
    private String token;

    public UserDTO() {
    }

    public UserDTO(Long id, String user, String email, String ubication, String token) {
        Id = id;
        this.user = user;
        this.email = email;
        this.ubication = ubication;
        this.token = token;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUbication() {
        return ubication;
    }

    public void setUbication(String ubication) {
        this.ubication = ubication;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
