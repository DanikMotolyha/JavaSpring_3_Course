package by.motolyha.scooter.service;

import by.motolyha.scooter.model.User;

import java.util.List;

public interface UserService {
    User findById(int id);

    void save(User user);

    List<User> findAll();

    void delete(int id);

    void updateUser(User user, int userId);
}
