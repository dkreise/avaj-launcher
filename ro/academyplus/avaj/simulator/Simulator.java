package ro.academyplus.avaj.simulator;

import java.io.*;

public class Simulator {
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide one scenario file as an argument.");
            return;
        }

        String filename = args[0];

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int cnt = 0;

            while ((line = reader.readLine()) != null) {
                cnt++;
                System.out.println("Line " + cnt + ": " + line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
