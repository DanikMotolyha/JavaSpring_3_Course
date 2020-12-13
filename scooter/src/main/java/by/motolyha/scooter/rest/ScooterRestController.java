package by.motolyha.scooter.rest;


import by.motolyha.scooter.model.Scooter;
import by.motolyha.scooter.service.impl.ScooterServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.io.StringWriter;

@RestController
@RequestMapping("/scooter")
public class ScooterRestController {

    @Autowired
    private ScooterServiceImpl scooterService;

    @GetMapping(value = "/{scooterId}")
    ResponseEntity<?> readUser(@PathVariable Integer scooterId) throws IOException {
        return new ResponseEntity<>(scooterService.findById(scooterId), HttpStatus.OK);
    }

    @PostMapping(value = "/all")
    ResponseEntity<?> readScooters() {
        return new ResponseEntity<>(scooterService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    void addScooter(@RequestBody @Valid Scooter scooter) {
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
