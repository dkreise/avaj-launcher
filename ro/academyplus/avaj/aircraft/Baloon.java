package ro.academyplus.avaj.aircraft;

import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.simulator.*;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }

    public void updateConditions() {
        // TODO
    }

    @Override
    public String toString() {
        return "Baloon#" + name + "(" + id + ")";
    }
}
