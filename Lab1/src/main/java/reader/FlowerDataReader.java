package reader;

import colors.Color;
import flowers.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlowerDataReader {
    public static List<Flower> readFlowersFromFile(String filename) {
        List<Flower> flowers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String name = parts[0];
                    String colorClassName = parts[1];
                    double price = Double.parseDouble(parts[2]);
                    int freshnessLevel = Integer.parseInt(parts[3]);
                    int stemLength = Integer.parseInt(parts[4]);

                    Color color = getColorObject(colorClassName);

                    Flower flower = createFlower(name, color, price, freshnessLevel, stemLength, parts);
                    if (flower != null) {
                        flowers.add(flower);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flowers;
    }

    private static Color getColorObject(String colorClassName) {
        try {
            Class<?> colorClass = Class.forName(colorClassName);
            return (Color) colorClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Flower createFlower(String name, Color color, double price, int freshnessLevel, int stemLength, String[] parts) {
        if (parts.length > 5) {
            String species = parts[5];
            return new Orchid(name, color, price, freshnessLevel, stemLength, species);
        } else if (parts.length > 6) {
            int numberOfPetals = Integer.parseInt(parts[6]);
            return new Rose(name, color, price, freshnessLevel, stemLength, numberOfPetals);
        } else if (parts.length > 7) {
            double seedSizeInInches = Double.parseDouble(parts[7]);
            return new Sunflower(name, color, price, freshnessLevel, stemLength, seedSizeInInches);
        } else if (parts.length > 8) {
            boolean isSpringBloomer = Boolean.parseBoolean(parts[8]);
            return new Tulip(name, color, price, freshnessLevel, stemLength, isSpringBloomer);
        }
        return null;
    }
}