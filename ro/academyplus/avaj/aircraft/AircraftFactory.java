package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.exceptions.*;

public class AircraftFactory {
    private static AircraftFactory aircraftFactory = new AircraftFactory();
    private long id = 0;

    private AircraftFactory() {}

    public static AircraftFactory getAircraftFactory() {
        return aircraftFactory;
    }

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraftTypeException {
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

    public Flyable newAircraft(String p_type, String p_name, int longitude, int latitude, int height) throws InvalidAircraftTypeException {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        return newAircraft(p_type, p_name, coordinates);
    }
}
