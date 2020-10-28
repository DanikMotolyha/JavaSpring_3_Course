package by.motolyha.scooter.service;

import by.motolyha.scooter.model.User;


public interface UserService  extends CrudService<User>{
    User findById(int id);
}
