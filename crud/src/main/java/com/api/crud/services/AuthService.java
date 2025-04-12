package com.api.crud.services;

import com.api.crud.models.Role;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.crud.dto.AuthResponse;
import com.api.crud.dto.RegisterRequest;
import com.api.crud.models.UserModel;
import com.api.crud.repositories.IUserRepository;

@Service
public class AuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    // Método para registrar un nuevo usuario
    public AuthResponse registerUser(RegisterRequest userRequest) {
        // Encriptar la contraseña antes de guardarla
        String encodedPassword = passwordEncoder.encode(userRequest.getPassword());

        // Crear un nuevo objeto UserModel a partir del DTO RegisterRequest
        UserModel user = new UserModel();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encodedPassword);
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setRole(Role.USER);  // Asumiendo que asignas un rol por defecto

        // Guardar el nuevo usuario
        userRepository.save(user);

        // Generar el token JWT para el nuevo usuario
        String token = jwtService.generateToken(user.getUsername(), user.getRole().name());

        // Devolver el mensaje de éxito junto con el token generado
        return new AuthResponse("Usuario registrado exitosamente", token);
    }

    // Método para autenticar un usuario (login)
    public String authenticateUser(String username, String password) {
        UserModel user = userRepository.findByUsername(username).orElse(null);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Si la autenticación es exitosa, generar el JWT
            return jwtService.generateToken(user.getUsername(), user.getRole().name());
        } else {
            // Si las credenciales son incorrectas, devolver un mensaje de error
            return "Credenciales inválidas.";
        }
    }
}
