package ru.geekbrains.homework6.services;

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

import javax.crypto.SecretKey;
import java.util.*;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

@Component
public class JwtTokenService {

    private final long JWT_TOKEN_VALIDITY = 10000;

    private final SecretKey SECRET = secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        for (GrantedAuthority auth : userDetails.getAuthorities()){
            claims.put("role", auth.getAuthority());
        }
        System.out.println("Токен генерируется");
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(String.valueOf(userDetails.getUsername()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();

        String userName = claims.getSubject();
        String role = claims.get("role", String.class);

        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));

        return new UsernamePasswordAuthenticationToken(userName, null, authorities);
    }

}
