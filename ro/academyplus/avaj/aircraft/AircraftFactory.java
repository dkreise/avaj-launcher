package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.simulator.*;

public class AircraftFactory {
    private static long id = 0;

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        id++;

        switch (p_type) {
            case "Baloon":
                return new Baloon(id, p_name, p_coordinates);
            case "Helicopter":
                return new Helicopter(id, p_name, p_coordinates);
            case "JetPlane":
                return new JetPlane(id, p_name, p_coordinates);
            default:
                throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
        }
    }
}
