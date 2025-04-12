package com.api.crud.dto;

public class AuthResponse {
    private String message;
    private String token;

    // Constructor para el mensaje
    public AuthResponse(String message) {
        this.message = message;
    }

    // Constructor para el token (usado en el login)
    public AuthResponse(String message, String token) {
        this.message = message;
        this.token = token;
    }

    // Getters y setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
