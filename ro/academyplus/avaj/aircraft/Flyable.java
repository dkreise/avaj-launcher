package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower tower);
}
