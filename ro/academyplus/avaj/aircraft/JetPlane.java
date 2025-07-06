package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.simulator.*;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
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
                coordinates.setLatitude(latitude + 10);
                coordinates.setHeight(height + 2);
                Writer.log(this + ": Where are my sunglasses?");
                break;
            case "RAIN":
                coordinates.setLatitude(latitude + 5);
                Writer.log(this + ": It's raining. Better watch out for lightings.");
                break;
            case "FOG":
                coordinates.setLatitude(latitude + 1);
                Writer.log(this + ": And now we are in the fog..");
                break;
            case "SNOW":
                coordinates.setHeight(height - 7);
                Writer.log(this + ": OMG! Winter is coming!");
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
        return "JetPlane#" + name + "(" + id + ")";
    }
}
