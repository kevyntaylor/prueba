package com.example.demo.controller;


import com.example.demo.dto.UserDTO;
import com.example.demo.models.Usuarios;
import com.example.demo.service.RolService;
import com.example.demo.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class TokenRestController {

    private final UserService service;
    private final RolService rolservice;

    @Autowired
    public TokenRestController(UserService service, RolService rolservice) {
        this.service = service;
        this.rolservice=rolservice;
    }

    @GetMapping("usertoken")
    public UserDTO login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
        UserDTO user = new UserDTO();
        Usuarios users = service.getUsr(email, pwd);
        if (users != null) {
            List<String> roles = rolservice.getRoles(users.getId());
            String token = getJWTToken(email,roles);
            user.setUser(users.getName() +" "+users.getLastname());
            user.setId(users.getId());
            user.setEmail(users.getEmail());
            user.setUbication(users.getCity().getCity()+ " - "+users.getCountry().getCountry());
            user.setToken(token);
            return user;
        } else {
            return null;
        }
    }

    private String getJWTToken(String username, List<String> roles) {
        String secretKey = "dEMO%0158*#S1573M45";
        String listString = String.join(", ", roles);
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList(listString);
        System.out.println(grantedAuthorities);
        String token = Jwts
                .builder()
                .setId("DevsoftcolSoftware")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
