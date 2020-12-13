package by.motolyha.scooter.rest;

import by.motolyha.scooter.config.jwt.JwtProvider;
import by.motolyha.scooter.dto.*;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@RestController
public class AuthRestController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserDto user) {
        User userEntity = new User(
                user.getUsername(),
                user.getSerName(),
                user.getLogin(),
                user.getPassword(),
                user.getMail()
        );
        userService.save(userEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/authorized")
    public ResponseEntity<?> isAuthorized() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<?> auth(@RequestBody @Valid UserAuthDto user) {
        User userEntity = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if(userEntity == null){
            String errorMsg = "Invalid login or password";
            return new ResponseEntity<>(errorMsg, HttpStatus.CONFLICT);
        }
        String token = jwtProvider.generateToken(user.getLogin());
        AuthResponse authResponse = new AuthResponse(token, user.getLogin());
        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }
    @GetMapping("/getUser/{login}")
    ResponseEntity<User> getUserByLogin(@PathVariable @Valid String login) {
        return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
    }
}
