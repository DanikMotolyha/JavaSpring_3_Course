package by.motolyha.scooter.service;

import java.util.List;

public interface CrudService<T> {

    void save(T obj);

    List<T> findAll();

    void delete(int id);

    void update(T obj, int objectId);
}
