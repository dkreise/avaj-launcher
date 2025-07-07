package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.aircraft.*;
import ro.academyplus.avaj.exceptions.*;

public class WeatherTower extends Tower {

    public WeatherTower() {
        super();
    }

    public String getWeather(Coordinates p_coordinates) {
        return WeatherProvider.getCurrentWeather(p_coordinates);
    }

    public void changeWeather() throws InvalidWeatherTypeException {
        this.conditionChanged();
        WeatherProvider.updateSeed();
    }
}
