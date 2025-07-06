package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.simulator.*;
import ro.academyplus.avaj.aircraft.*;
import java.util.Random;

public class WeatherProvider {
    private static String[] weatherTypes = {"SUN", "RAIN", "FOG", "SNOW"};
    private static int roundSeed = 0;
    
    private WeatherProvider() {}

    public static String getCurrentWeather(Coordinates p_coordinates) {
        int longitude = p_coordinates.getLongitude();
        int latitude = p_coordinates.getLatitude();
        int height = p_coordinates.getHeight();
        
        int hash = (longitude * 13) + (latitude * 17) + (height * 31) + roundSeed;
        Random rand = new Random(hash);
        int idx = rand.nextInt(4);
        return weatherTypes[idx];
    }

    public static void updateSeed() {
        roundSeed++;
    }
}