package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.simulator.*;
import ro.academyplus.avaj.exceptions.*;

public class AircraftFactory {
    private static long id = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraftTypeException {
        id++;

        switch (p_type) {
            case "Baloon":
                return new Baloon(id, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id, p_name, p_coordinates);
            default:
                throw new InvalidAircraftTypeException("Unknown aircraft type: " + p_type);
        }
    }

    public static Flyable newAircraft(String p_type, String p_name, int longitude, int latitude, int height) throws InvalidAircraftTypeException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        return newAircraft(p_type, p_name, coordinates);
    }
}
