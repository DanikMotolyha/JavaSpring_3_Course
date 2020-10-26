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
    public User findById(int userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(
                        String.format("User with Id %d not found", userId)));
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
    public void delete(int userId) {
        if (userRepository.findById(userId).isPresent()) {
            userRepository.deleteById(userId);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", userId));
    }

    @Override
    public void updateUser(User user, int userId) {
        if (userRepository.findById(userId).isPresent()) {
            User userLink = this.userRepository.findById(userId).get();
            userLink.setName(user.getName());
            userLink.setSerName(user.getSerName());
            userLink.setLogin(user.getLogin());
            userLink.setPassword(
                    DigestUtils.md5DigestAsHex(user.getPassword().getBytes()).toUpperCase());
            userLink.setMail(user.getMail());
            this.userRepository.save(userLink);
        } else throw new UserNotFoundException(
                String.format("User with Id %d not found", userId));
    }
}
