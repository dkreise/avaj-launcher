package ro.academyplus.avaj.weather;

import ro.academyplus.avaj.aircraft.*;
import ro.academyplus.avaj.simulator.Writer;
import ro.academyplus.avaj.exceptions.*;

import java.util.List;
import java.util.ArrayList;

public class Tower {
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable p_flyable) {
        // maybe check if already present
        observers.add(p_flyable);
        Writer.log("Tower says: " + p_flyable + " registered to weather tower.");
    }

    public void unregister(Flyable p_flyable) {
        // maybe also check
        observers.remove(p_flyable);
        Writer.log("Tower says: " + p_flyable + " unregistered from weather tower.");
    }

    void conditionChanged() throws InvalidWeatherTypeException {
        // as we can't modify list while iterating through it:
        List<Flyable> currentObservers = new ArrayList<>(observers);

        for (Flyable aircraft : currentObservers) {
            aircraft.updateConditions();
        }
    }
}
