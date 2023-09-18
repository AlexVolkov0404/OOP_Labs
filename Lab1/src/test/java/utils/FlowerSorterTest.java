package utils;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import flowers.Flower;
import colors.Color;
import utils.FlowerSorter;
import java.util.List;
import java.util.ArrayList;

public class FlowerSorterTest {
    @Test
    public void testSortFlowersByFreshness() {
        List<Flower> flowers = new ArrayList<>();
        flowers.add(new Flower("Rose1", new Color("Red"), 10.0, 5, 15));
        flowers.add(new Flower("Tulip1", new Color("Yellow"), 8.0, 4, 12));
        flowers.add(new Flower("Orchid1", new Color("Purple"), 12.0, 3, 14));
        flowers.add(new Flower("Rose2", new Color("White"), 9.0, 6, 17));


        FlowerSorter.sortFlowersByFreshness(flowers);


        assertEquals("Rose2", flowers.get(0).getName());
        assertEquals("Rose1", flowers.get(1).getName());
        assertEquals("Tulip1", flowers.get(2).getName());
        assertEquals("Orchid1", flowers.get(3).getName());
    }
}