package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.aircraft.*;
import ro.academyplus.avaj.weather.*;
import ro.academyplus.avaj.exceptions.*;
import java.io.*;

public class Simulator {
    private static int simulationsNum;
    private static WeatherTower weatherTower = new WeatherTower();
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide one scenario file as an argument.");
            return;
        }

        String filename = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;

            line = reader.readLine();
            if (line != null) {
                line = line.trim();
                simulationsNum = Integer.parseInt(line);
                if (simulationsNum < 0) {
                    System.out.println("Error: Negative number of simulations.");
                    return;
                }
            }

            /* REGISTRATION LOOP */
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    throw new InvalidScenarioException("Invalid scenario line: " + line);
                }
                addAircraft(parts);
            }

            /* SIMULATION LOOP */
            for (int i = 0; i < simulationsNum; i++) {
                weatherTower.changeWeather();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: wrong number format.");
        } catch (InvalidScenarioException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidCoordinateException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidWeatherTypeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InvalidAircraftTypeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Writer.close();
    }

    public static void addAircraft(String[] parts) throws InvalidCoordinateException, InvalidAircraftTypeException {
        String type = parts[0];
        String name = parts[1];
        int longitude = Integer.parseInt(parts[2]);
        int latitude = Integer.parseInt(parts[3]);
        int height = Integer.parseInt(parts[4]);

        if (longitude < 1 || latitude < 1 || height < 0 || height > 100) {
            throw new InvalidCoordinateException("Coordinates are in the invalid range.");
        }

        Flyable aircraft = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
        aircraft.registerTower(weatherTower);
    }
}
