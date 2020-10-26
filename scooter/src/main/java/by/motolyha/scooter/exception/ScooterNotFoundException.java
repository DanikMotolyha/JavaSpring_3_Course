package by.motolyha.scooter.exception;

public class ScooterNotFoundException extends RuntimeException {

    public ScooterNotFoundException(int id) {

        super(String.format("Scooter with Id %d not found", id));
    }
}
