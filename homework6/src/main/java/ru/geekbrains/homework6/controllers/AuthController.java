package ru.geekbrains.homework6.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.homework6.model.UserDTO;
import ru.geekbrains.homework6.services.JwtTokenService;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JwtTokenService jwtTokenService;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody UserDTO user){
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.username());
        if (bCryptPasswordEncoder.matches(user.password(), userDetails.getPassword())){
            String token = jwtTokenService.generateToken(userDetails);
            return new ResponseEntity<>("Bearer " + token, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
