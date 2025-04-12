package com.api.crud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.dto.AuthResponse;
import com.api.crud.dto.LoginRequest;
import com.api.crud.dto.RegisterRequest;
import com.api.crud.services.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService; // Inyección de AuthService

    // Endpoint para registrar un nuevo usuario
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest userRequest) {
        // Llamamos a la función registerUser de AuthService y generamos el token después de registrar
        AuthResponse response = authService.registerUser(userRequest);
        return ResponseEntity.ok(response); // Devolvemos la respuesta con el mensaje y token
    }

    // Endpoint para iniciar sesión (login)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        // Llamamos a la función authenticateUser de AuthService
        String token = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());
        
        if (token.equals("Credenciales inválidas.")) {
            return ResponseEntity.status(401).body(new AuthResponse(token)); // Credenciales incorrectas
        }
        
        // Si el token es generado correctamente, retornamos el token en la respuesta
        return ResponseEntity.ok(new AuthResponse("Login exitoso", token));
    }
}
