package by.motolyha.scooter.service.impl;

import by.motolyha.scooter.exception.NoDataFoundException;
import by.motolyha.scooter.exception.ScooterNotFoundException;
import by.motolyha.scooter.exception.UserNotFoundException;
import by.motolyha.scooter.model.Scooter;
import by.motolyha.scooter.repository.ScooterRepository;
import by.motolyha.scooter.service.ScooterService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class ScooterServiceImpl implements ScooterService {
    private static final java.util.logging.Logger LOGGER = Logger.getLogger(String.valueOf(ScooterServiceImpl.class));



    @Autowired
    private ScooterRepository scooterRepository;

    @Override
    public Scooter findById(int id) {
        LOGGER.info("fin by id" + id);
        return scooterRepository.findById(id)
                .orElseThrow(() -> new ScooterNotFoundException(
                        String.format("Scooter with Id %d not found", id)));
    }

    @Override
    public void save(Scooter scooter) {
        LOGGER.info("save Scooter + " + scooter.getName());
        this.scooterRepository.save(scooter);
    }

    @Override
    public List<Scooter> findAll() {
        LOGGER.info("find all");
        return scooterRepository.findAll();
    }

    @Override
    public void delete(int id) {
        LOGGER.info("delete " + id);
        if (scooterRepository.findById(id).isPresent()) {
            scooterRepository.deleteById(id);
        } else LOGGER.log(Level.FINEST,String.format("Scooter with Id %d not found", id));
    }

    @Override
    public void update(Scooter obj, int id) {
        LOGGER.info("delete Scooter with id" + id);
        if (scooterRepository.findById(id).isPresent()) {
            Scooter scooterLink = scooterRepository.findById(id).get();
            scooterLink.setName(obj.getName());
            scooterLink.setPrice(obj.getPrice());
            this.scooterRepository.save(scooterLink);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", id));

    }
}
