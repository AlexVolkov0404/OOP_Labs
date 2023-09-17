package utils;
import java.util.ArrayList;
import java.util.List;

import bouquet.FlowerBouquet;
import flowers.Flower;

public class FlowerFinder {
    public static List<Flower> findFlowersInStemLengthRange(FlowerBouquet bouquet, int minStemLength, int maxStemLength) {
        List<Flower> foundFlowers = new ArrayList<>();

        for (Flower flower : bouquet.getFlowers()) {
            int stemLength = flower.getStemLength();
            if (stemLength >= minStemLength && stemLength <= maxStemLength) {
                foundFlowers.add(flower);
            }
        }

        return foundFlowers;
    }
}
