package reader;
import bouquet.Accessory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDataReader {
    public static List<Accessory> readAccessoriesFromFile(String filename) {
        List<Accessory> accessories = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    double price = Double.parseDouble(parts[1]);

                    accessories.add(new Accessory(name, price));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accessories;
    }
}