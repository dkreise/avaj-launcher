package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.simulator.*;

public abstract class Aircraft implements Flyable {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected WeatherTower weatherTower;

    protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }

    @Override
    public void registerTower(WeatherTower tower) {
        this.weatherTower = tower;
        tower.register(this);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }
}