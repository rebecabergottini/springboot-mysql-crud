package com.api.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.crud.models.UserModel;

/* @Repository Indica que esta interfaz es un componente de acceso a datos (DAO).
Spring la detectará automáticamente para gestionar operaciones de base de datos.
JpaRepository Proporciona métodos CRUD predefinidos (Create, Read, Update, Delete) sin necesidad de implementarlos manualmente.
UserModel es la entidad gestionada.
Long es el tipo de dato de la clave primaria (id). */
@Repository 
public interface IUserRepository extends JpaRepository<UserModel, Long>{

    
}
