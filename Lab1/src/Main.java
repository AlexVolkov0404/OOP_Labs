import bouquet.Accessory;
import bouquet.FlowerBouquet;
import flowers.Flower;
import menu.ConsoleMenu;
import reader.AccessoryDataReader;
import reader.FlowerDataReader;
import utils.FlowerFinder;
import utils.FlowerSorter;

import java.util.List;
public class Main {
    public static void main(String[] args) {

        ConsoleMenu menu = new ConsoleMenu();
        menu.run();
    }
}