package by.motolyha.scooter.rest;


import by.motolyha.scooter.dto.ScooterDto;
import by.motolyha.scooter.dto.ScooterDtoId;
import by.motolyha.scooter.model.Scooter;
import by.motolyha.scooter.model.ScooterDtoFull;
import by.motolyha.scooter.service.impl.ScooterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping
public class ScooterRestController {
    @Autowired
    private ScooterServiceImpl scooterService;
    @PostMapping(value = "/scooter/all")
    ResponseEntity<?> readScooters() {
        return new ResponseEntity<>(scooterService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    void addScooter(@RequestBody @Valid Scooter scooter) {
        scooterService.save(scooter);
    }

    @GetMapping(value = "/admin/SearchScooterById/{scooterId}")
    ResponseEntity<?> updateScooter(@PathVariable Integer scooterId) {
        return new ResponseEntity<>(scooterService.findById(scooterId), HttpStatus.OK);
    }

    @DeleteMapping(value = "/admin/deleteScooterById")
    void deleteScooter(@RequestBody @Valid ScooterDtoId id) {
        scooterService.delete(id.getId());
    }

    @PostMapping(value = "/admin/updateScooter")
    void updateScooter(@RequestBody @Valid ScooterDtoFull scooter) {
        scooterService.update(new Scooter(scooter.getName(), scooter.getPrice()), scooter.getId());
    }


    @PostMapping(value = "/admin/createScooter")
    void createScooter(@RequestBody @Valid ScooterDto scooter) {
        scooterService.save(new Scooter(scooter.getName(), scooter.getPrice()));
    }
}
