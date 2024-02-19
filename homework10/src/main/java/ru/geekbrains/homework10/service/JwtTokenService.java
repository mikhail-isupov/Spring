package ru.geekbrains.homework10.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.security.Keys;
import ru.geekbrains.homework10.model.User;
import ru.geekbrains.homework10.model.UserEntity;

import javax.crypto.SecretKey;
import java.util.*;

import static io.jsonwebtoken.security.Keys.secretKeyFor;
@Component
public class JwtTokenService {
    private final long JWT_TOKEN_VALIDITY = 10000;

    private final SecretKey SECRET = secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(UserEntity registeredUser) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "USER");

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(registeredUser.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
}
