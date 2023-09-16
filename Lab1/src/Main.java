import bouquet.Accessory;
import bouquet.FlowerBouquet;
import flowers.Flower;
import reader.AccessoryDataReader;
import reader.FlowerDataReader;

import java.util.List;



public class Main {
    public static void main(String[] args) {
        String accessoriesFile = "D:\\Common\\University\\3курс\\OOP\\OOP_Labs\\Lab1\\src\\accessories.txt";


        List<Accessory> accessories = AccessoryDataReader.readAccessoriesFromFile(accessoriesFile);
        FlowerBouquet bouquet = new FlowerBouquet();
        for (Accessory accessory : accessories) {
            bouquet.addAccessory(accessories.get(0));
        }
        String orchidsFile = "D:\\Common\\University\\3курс\\OOP\\OOP_Labs\\Lab1\\src\\orchids.txt";
        List<Flower> orchids = FlowerDataReader.readFlowersFromFile(orchidsFile);
        for (Flower orchid : orchids) {
            bouquet.addFlower(orchid);
        }
        bouquet.describe();

    }
}