package ro.academyplus.avaj.simulator;

import ro.academyplus.avaj.aircraft.*;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Simulator {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide one scenario file as an argument.");
            return;
        }

        String filename = args[0];
        int simulations_num;
        List<Flyable> aircrafts = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int cnt = 0;

            line = reader.readLine();
            if (line != null) {
                simulations_num = Integer.parseInt(line);
                if (simulations_num < 0) {
                    System.out.println("Error: Negative number of simulations.");
                    return;
                }
                System.out.println("Simulations number: " + simulations_num);
            }

            while ((line = reader.readLine()) != null) {
                cnt++;
                String[] parts = line.split(" ");
                if (parts.length != 5) {
                    System.out.println("Error: Invalid aircraft line: " + line);
                    return;
                }
                System.out.println("Aircraft " + cnt + ": " + line);

                String type = parts[0];
                String name = parts[1];
                int longitude = Integer.parseInt(parts[2]);
                int latitude = Integer.parseInt(parts[3]);
                int height = Integer.parseInt(parts[4]);

                Coordinates coordinates = new Coordinates(longitude, latitude, height);
                Flyable aircraft = AircraftFactory.newAircraft(type, name, coordinates);
                aircrafts.add(aircraft);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: wrong number format.");
        }

        Writer.log("we are done!");
        // System.out.println("Num of aircrafts: " + aircrafts.length);
        Writer.log("Num of aircrafts: " + aircrafts.size());
        Writer.close();
    }
}
