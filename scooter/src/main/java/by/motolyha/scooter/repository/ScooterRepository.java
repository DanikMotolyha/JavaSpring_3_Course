package by.motolyha.scooter.repository;

import by.motolyha.scooter.model.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScooterRepository extends JpaRepository<Scooter, Integer> {
}
