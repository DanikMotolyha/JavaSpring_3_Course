package by.motolyha.scooter.service.impl;

import by.motolyha.scooter.exception.NoDataFoundException;
import by.motolyha.scooter.exception.ScooterNotFoundException;
import by.motolyha.scooter.exception.UserNotFoundException;
import by.motolyha.scooter.model.Scooter;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.repository.ScooterRepository;
import by.motolyha.scooter.repository.UserRepository;
import by.motolyha.scooter.service.ScooterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class ScooterServiceImpl implements ScooterService {


    private final static Logger LOGGER = LoggerFactory.getLogger(ScooterServiceImpl.class);

    @Autowired
    private ScooterRepository scooterRepository;

    @Override
    public Scooter findById(int id) {
        LOGGER.info("FindByID");
        return scooterRepository.findById(id)
                .orElseThrow(() -> new ScooterNotFoundException(
                        String.format("Scooter with Id %d not found", id)));
    }

    @Override
    public void save(Scooter scooter) {
        this.scooterRepository.save(scooter);
    }

    @Override
    public List<Scooter> findAll() {
        List<Scooter> scooter = scooterRepository.findAll();
        if (scooter.isEmpty()) {
            throw new NoDataFoundException("Scooters");
        }
        return scooter;
    }

    @Override
    public void delete(int id) {
        if (scooterRepository.findById(id).isPresent()) {
            scooterRepository.deleteById(id);
        } else throw new UserNotFoundException(
                String.format("Scooter with Id %d not found", id));
    }

    @Override
    public void update(Scooter scooter, int id) {
        if (scooterRepository.findById(id).isPresent()) {
            Scooter scooterLink = this.scooterRepository.findById(id).get();
            scooterLink.setName(scooter.getName());
            scooterLink.setPrice(scooter.getPrice());
            this.scooterRepository.save(scooterLink);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", id));

    }
}
