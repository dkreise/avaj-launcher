package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.exceptions.*;

public interface Flyable {
    public void updateConditions() throws InvalidWeatherTypeException;
    public void registerTower(WeatherTower tower);
}
