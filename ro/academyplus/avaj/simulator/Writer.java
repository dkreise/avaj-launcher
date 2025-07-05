package ro.academyplus.avaj.simulator;

import java.io.*;

public class Writer {
    private static BufferedWriter writer;

    static {
        try {
            writer = new BufferedWriter(new FileWriter("simulation.txt"));
        } catch (IOException e) {
            System.out.println("Error: unable to create output file.");
            System.exit(1);
        }
    }

    public static void log(String logline) {
        try {
            writer.write(logline);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static void close() {
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("Error closing file.");
        }
    }
}
