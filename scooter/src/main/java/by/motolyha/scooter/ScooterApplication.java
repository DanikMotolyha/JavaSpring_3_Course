package by.motolyha.scooter;

import by.motolyha.scooter.model.User;
import by.motolyha.scooter.repository.ScooterRepository;
import by.motolyha.scooter.repository.UserRepository;
import by.motolyha.scooter.service.ScooterService;
import by.motolyha.scooter.service.UserService;
import by.motolyha.scooter.service.impl.ScooterServiceImpl;
import by.motolyha.scooter.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScooterApplication {
    private static final Logger log = LoggerFactory.getLogger(ScooterApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(ScooterApplication.class, args);
    }

    @Autowired
    private UserServiceImpl userService;
}
