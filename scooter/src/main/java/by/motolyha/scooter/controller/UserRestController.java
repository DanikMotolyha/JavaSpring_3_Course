package by.motolyha.scooter.controller;

import by.motolyha.scooter.model.User;
import by.motolyha.scooter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    User readUser(@PathVariable Integer userId) {
        return userService.findById(userId);
    }

    @GetMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    Collection<User> readUsers() {
        return userService.findAll();
    }

    @PostMapping()
    void addUser(@RequestBody @Valid User user) {
        userService.save(user);
    }

    @PutMapping(value = "/{userId}")
    void updateUser(@RequestBody @Valid User user, @PathVariable int userId) {
        userService.updateUser(user, userId);
    }

    @DeleteMapping(value = "/{userId}")
    void deleteUser(@PathVariable int userId) {
        userService.delete(userId);
    }
}
