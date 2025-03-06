package com.api.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica que esta clase representa una tabla en la base de datos.
@Table(name = "user") // Define explícitamente que la tabla en la base de datos se llamará user.
public class UserModel {
    @Id // El campo id es la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará automáticamente el ID de forma incremental.
    private Long id;
    
    // Los atributos firstName, lastName y email se mapearán como columnas en la tabla user.
    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    public Long getId() {
        return id;
    }   

    public void setId(Long id) {
        this.id = id;
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

}
