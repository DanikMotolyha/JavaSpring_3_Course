package by.motolyha.scooter.service.impl;

import by.motolyha.scooter.config.jwt.JwtProvider;
import by.motolyha.scooter.exception.NoDataFoundException;
import by.motolyha.scooter.exception.UserNotFoundException;
import by.motolyha.scooter.model.Orders;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.model.UserType;
import by.motolyha.scooter.repository.OrderRepository;
import by.motolyha.scooter.repository.UserRepository;
import by.motolyha.scooter.repository.UserTypeRepository;
import by.motolyha.scooter.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserTypeRepository UserTypeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public User findByLogin(String login){
        return userRepository.findByLogin(login);
    }

    @Override
    public User findById(int id) {
        LOGGER.info("findById");
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with Id %d not found", id)));
    }

    @Override
    public void save(User user) {
        UserType type = UserTypeRepository.findByUserType("ROLE_USER");
        user.setUserType(type);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findByLoginAndPassword(String login, String password) {
        User userEntity = findByLogin(login);
        if (userEntity != null) {
            if (passwordEncoder.matches(password, userEntity.getPassword())) {
                return userEntity;
            }
        }
        return null;
    }
    @Override
    public void delete(int id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", id));
    }

    @Override
    public void update(User user, int id) {
        if (userRepository.findById(id).isPresent()) {
            User userLink = this.userRepository.findById(id).get();
            userLink.setName(user.getName());
            userLink.setSerName(user.getSerName());
            userLink.setLogin(user.getLogin());
            userLink.setPassword(
                    DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).toUpperCase());
            userLink.setMail(user.getMail());
            this.userRepository.save(userLink);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", id));
    }
}
