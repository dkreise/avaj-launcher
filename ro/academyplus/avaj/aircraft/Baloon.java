package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.simulator.*;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String weather = weatherTower.getWeather(coordinates);

        // TODO: try catch
        switch (weather) {
            case "SUN":
                coordinates.setLongitude(longitude + 2);
                coordinates.setHeight(height + 4);
                Writer.log(this + ": Let's enjoy the good weather and take some pics.");
                break;
            case "RAIN":
                coordinates.setHeight(height - 5);
                Writer.log(this + ": We're getting wet!");
                break;
            case "FOG":
                coordinates.setHeight(height - 3);
                Writer.log(this + ": Where are we?");
                break;
            case "SNOW":
                coordinates.setHeight(height - 15);
                Writer.log(this + ":  It's snowing. We're gonna crash.");
                break;
            default:
                // throw custom exception
        }

        if (coordinates.getHeight() <= 0) {
            Writer.log(this + " landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}
