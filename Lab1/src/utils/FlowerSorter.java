package utils;
import flowers.Flower;

import java.util.List;

public class FlowerSorter {
    public static void sortFlowersByFreshness(List<Flower> flowers) {
        for (int i = 1; i < flowers.size(); i++) {
            Flower currentFlower = flowers.get(i);
            int j = i - 1;

            while (j >= 0 && currentFlower.getFreshnessLevel() > flowers.get(j).getFreshnessLevel()) {
                flowers.set(j + 1, flowers.get(j));
                j--;
            }

            flowers.set(j + 1, currentFlower);
        }
    }
}