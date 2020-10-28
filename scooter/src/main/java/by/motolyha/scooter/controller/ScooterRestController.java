package by.motolyha.scooter.controller;


import by.motolyha.scooter.model.Scooter;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.service.ScooterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/scooters")
public class ScooterRestController {

    @Autowired
    private ScooterService scooterService;

    @GetMapping(value = "/{scooterId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    Scooter readUser(@PathVariable Integer scooterId) {
        return scooterService.findById(scooterId);
    }

    @GetMapping(value = "/",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    Collection<Scooter> readScooters() {
        return scooterService.findAll();
    }

    @PostMapping()
    void addScooter(@RequestBody @Valid Scooter scooter,
                 BindingResult bindingResult, Model model) {
        scooterService.save(scooter);
    }

    @PutMapping(value = "/{scooterId}")
    void updateScooter(@RequestBody @Valid Scooter scooter, @PathVariable int scooterId) {
        scooterService.update(scooter, scooterId);
    }

    @DeleteMapping(value = "/{scooterId}")
    void deleteScooter(@PathVariable int scooterId) {
        scooterService.delete(scooterId);
    }


}
