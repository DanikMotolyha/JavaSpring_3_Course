package by.motolyha.scooter.exception;

public class NoDataFoundException extends RuntimeException {

    public NoDataFoundException(String nameTable) {
        super (String.format("No data found in table %s", nameTable));
    }
}
