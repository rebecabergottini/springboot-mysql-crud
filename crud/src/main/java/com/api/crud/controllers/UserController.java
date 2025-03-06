package com.api.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.crud.models.UserModel;
import com.api.crud.services.UserService;

@RestController // Indica que esta clase es un controlador de Spring para manejar solicitudes HTTP.
@RequestMapping("/user") // Define la ruta base para las peticiones a este controlador.
public class UserController {

    @Autowired // Permite acceder a los métodos del servicio sin necesidad de instanciarlo manualmente.
    private UserService userService;
    
    @GetMapping // Mapea solicitudes GET a la ruta /user. Retorna un ArrayList en formato JSON.
    public ArrayList<UserModel> getUsers() {
        return this.userService.getUsers();
    }
    
    @PostMapping // Mapea solicitudes POST a la ruta /user. Retorna un UserModel en formato JSON.
    public UserModel saveUser(@RequestBody UserModel user) {
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}") // Mapea solicitudes GET a la ruta /user/{id}. Retorna un UserModel en formato JSON.
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}") // Mapea solicitudes PUT a la ruta /user/{id}. Retorna un UserModel en formato JSON.
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id) {
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}") // Mapea solicitudes DELETE a la ruta /user/{id}. Retorna un booleano en formato JSON.
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.userService.deleteUser(id);
        if (ok) {
            return "User whit id " + id + " deleted";
        } else {
            return "User not found";
        }
    }
}
