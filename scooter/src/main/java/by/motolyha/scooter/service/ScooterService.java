package by.motolyha.scooter.service;

import by.motolyha.scooter.model.Scooter;

public interface ScooterService extends CrudService<Scooter> {
    Scooter findById(int id);
}
