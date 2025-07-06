package ro.academyplus.avaj.exceptions;

public class InvalidAircraftTypeException extends Exception {

    public InvalidAircraftTypeException() {
        super("Invalid aircraft type.");
    }

    public InvalidAircraftTypeException(String message) {
        super(message);
    }
}
