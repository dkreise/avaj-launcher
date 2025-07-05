package ro.academyplus.avaj.exceptions;

public class InvalidScenarioException extends Exception {

    public InvalidScenarioException() {
        super("Invalid scenario.");
    }

    public InvalidScenarioException(String message) {
        super(message);
    }
}
