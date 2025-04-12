package com.api.crud.services;

import java.sql.Date;

import org.springframework.stereotype.Service;
import java.time.Instant;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;

@Service
public class JwtService {
    private String secretKey;

    // Tiempo de expiración del token (en milisegundos)
    private static final long EXPIRATION_TIME = 86400000; // 1 día en milisegundos

    public Claims decodeToken(String token) {
        Key key = Keys.hmacShaKeyFor(secretKey.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    
    // Generar el token
    public String generateToken(String username, String role) {
        System.out.println("Generating token for username: " + username); // Verifica si se llega a este punto
        System.out.println("Using secretKey: " + secretKey);
        return Jwts.builder()
            .setSubject(username)  // El nombre de usuario como sujeto del token
            .claim("role", role)   // Agregar el rol al token
            .setIssuedAt(Date.from(Instant.now()))  // Establecer la fecha de emisión
            .setExpiration(Date.from(Instant.now().plusMillis(EXPIRATION_TIME)))  // Establecer la fecha de expiración
            .signWith(getKey(), SignatureAlgorithm.HS512)  // Usar la clave generada para firmar el token
            .compact();  // Generar el JWT compactado
    }

    // Obtener la clave secreta
    private Key getKey() {
        return Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }
}
