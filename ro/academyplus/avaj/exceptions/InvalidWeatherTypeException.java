package ro.academyplus.avaj.exceptions;

public class InvalidWeatherTypeException extends Exception {

    public InvalidWeatherTypeException() {
        super("Invalid weather type.");
    }

    public InvalidWeatherTypeException(String message) {
        super(message);
    }
}
