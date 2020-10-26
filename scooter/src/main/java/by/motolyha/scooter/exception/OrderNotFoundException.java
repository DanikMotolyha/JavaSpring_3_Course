package by.motolyha.scooter.exception;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(int id) {

        super(String.format("Order with Id %d not found", id));
    }
}
