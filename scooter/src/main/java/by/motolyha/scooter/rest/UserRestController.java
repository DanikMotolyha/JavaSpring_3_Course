package by.motolyha.scooter.rest;

import by.motolyha.scooter.config.jwt.JwtProvider;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.service.UserService;
import by.motolyha.scooter.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    private OrderServiceImpl orderService;
    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping(value = "/{userId}")
    User readUser(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping(value = "/")
    ResponseEntity<?> readUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/getUserOrders/{userLogin}")
    ResponseEntity<?> getUserOrders(@PathVariable String userLogin) {
        return new ResponseEntity<>(orderService.findAll()
                .stream()
                .filter(
                        e -> e.getUser().getLogin().equals(userLogin)
                ).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping()
    void addUser(@RequestBody @Valid User user) {
        userService.save(user);
    }

    @PutMapping(value = "/{userId}")
    void updateUser(@RequestBody @Valid User user, @PathVariable int userId) {
        userService.update(user, userId);
    }

    @DeleteMapping(value = "/{userId}")
    void deleteUser(@PathVariable int userId) {
        userService.delete(userId);
    }


    @GetMapping("/getUser/{login}")
    ResponseEntity<User> getUserByLogin(@PathVariable @Valid String login) {
        return new ResponseEntity<>(userService.findByLogin(login), HttpStatus.OK);
    }
}
