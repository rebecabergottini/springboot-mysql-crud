package com.api.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

@Service // Spring la detecta automáticamente para la inyección de dependencias.
public class UserService {

    @Autowired // Permite acceder a los métodos del repositorio sin necesidad de instanciarlo manualmente.
    IUserRepository userRepository; // se inyecta automáticamente para interactuar con la base de datos.

    public ArrayList<UserModel> getUsers(){
        return (ArrayList<UserModel>) userRepository.findAll(); // método findAll() de JpaRepository, obtiene todos los registros de la entidad UserModel.
    }

    public UserModel saveUser(UserModel user) {
        return userRepository.save(user); // método save() de JpaRepository, guarda un registro en la base de datos.
    }

    public Optional<UserModel> getById(Long id){
        return userRepository.findById(id); // método findById() de JpaRepository, obtiene un registro por su id.
    }

    public UserModel updateById(UserModel request, Long id){
        UserModel user = userRepository.findById(id).get();
        
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        userRepository.save(user);
        return user;
    }

    public Boolean deleteUser (Long id){
        try {
            userRepository.deleteById(id); // método deleteById() de JpaRepository, elimina un registro por su id.
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
