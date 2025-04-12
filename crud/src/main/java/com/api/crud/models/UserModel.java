package com.api.crud.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase representa una tabla en la base de datos.
@Table(name = "user") // Define explícitamente que la tabla en la base de datos se llamará user.
public class UserModel implements UserDetails {
    @Id // El campo id es la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará automáticamente el ID de forma incremental.
    private Long id;
    
    @Column(unique = true) // Hacer que el nombre de usuario sea único
    private String username;

    @Column // La contraseña del usuario
    private String password;

    // Los atributos firstName, lastName y email se mapearán como columnas en la tabla user.
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(unique = true) // Hacer que el email sea único
    private String email;

    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role; // Aquí devolvemos el rol correctamente
    }

    public void setRole(Role role) {
        this.role = role; // Asignamos el rol al usuario
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convertimos el rol a un formato que Spring Security entiende
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
}
