package by.motolyha.scooter.controller;

import by.motolyha.scooter.config.jwt.JwtProvider;
import by.motolyha.scooter.dto.*;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.model.UserType;
import by.motolyha.scooter.service.UserService;
import by.motolyha.scooter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
@RestController
public class AuthController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid UserDto user) {
        User userEntity = new User(
                user.getUsername(),
                user.getSerName(),
                user.getLogin(),
                user.getPassword(),
                user.getMail()
        );
        userService.save(userEntity);
        return "OK";
    }

    @PostMapping("/auth")
    public String auth(@RequestBody @Valid UserAuthDto user) {
        User userEntity = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if(userEntity == null){
            return "Invalid login or password";
        }
        return jwtProvider.generateToken(userEntity.getLogin());
    }
}
