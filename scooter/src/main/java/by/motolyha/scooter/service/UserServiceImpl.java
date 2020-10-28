package by.motolyha.scooter.service;

import by.motolyha.scooter.exception.NoDataFoundException;
import by.motolyha.scooter.exception.UserNotFoundException;
import by.motolyha.scooter.model.User;
import by.motolyha.scooter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with Id %d not found", id)));
    }

    @Override
    public void save(User user) {
        user.setPassword(
                DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).toUpperCase());
        this.userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()) {
            throw new NoDataFoundException("Users");
        }
        return users;
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
