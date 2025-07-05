package ro.academyplus.avaj.exceptions;

public class InvalidCoordinateException extends Exception {

    public InvalidCoordinateException() {
        super("Invalid coordinates.");
    }

    public InvalidCoordinateException(String message) {
        super(message);
    }
}
