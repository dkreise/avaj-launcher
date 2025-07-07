package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.simulator.Writer;
import ro.academyplus.avaj.exceptions.*;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() throws InvalidWeatherTypeException {
        int longitude = coordinates.getLongitude();
        int height = coordinates.getHeight();
        String weather = weatherTower.getWeather(coordinates);

        switch (weather) {
            case "SUN":
                coordinates.setLongitude(longitude + 10);
                coordinates.setHeight(height + 2);
                Writer.log(this + ": This is hot.");
                break;
            case "RAIN":
                coordinates.setLongitude(longitude + 5);
                Writer.log(this + ": It's raining men! Hallelujah!");
                break;
            case "FOG":
                coordinates.setLongitude(longitude + 1);
                Writer.log(this + ": I can't see anything..");
                break;
            case "SNOW":
                coordinates.setHeight(height - 12);
                Writer.log(this + ": Baby, it's cold outside!");
                break;
            default:
                throw new InvalidWeatherTypeException();
        }

        if (coordinates.getHeight() <= 0) {
            Writer.log(this + " landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Helicopter#" + name + "(" + id + ")";
    }
}
