package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.aircraft.Coordinates;

public class WeatherProvider {
    private String[] weatherTypes = {"Sunny", "Rain", "Foggy", "Snow"};
    
    private WeatherProvider() {
    }

    // public static WeatherProvider getInstance() {
    //     if (weatherProvider == null) {
    //         weatherProvider = new WeatherProvider();
    //     }
    //     return weatherProvider;
    // }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int height = p_coordinates.getHeight();
        int latitude = p_coordinates.getLatitude();
        int longitude = p_coordinates.getLongitude();

        // TODO
        return "cur weather";
    }
}