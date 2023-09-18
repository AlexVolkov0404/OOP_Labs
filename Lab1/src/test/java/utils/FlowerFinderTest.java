package utils;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import bouquet.FlowerBouquet;
import flowers.Flower;
import colors.Color;
import utils.FlowerFinder;
import java.util.List;
import java.util.ArrayList;

public class FlowerFinderTest {
    @Test
    public void testFindFlowersInStemLengthRange() {
        FlowerBouquet bouquet = new FlowerBouquet();
        bouquet.addFlower(new Flower("Rose1", new Color("Red"), 10.0, 5, 15));
        bouquet.addFlower(new Flower("Tulip1", new Color("Yellow"), 8.0, 4, 12));
        bouquet.addFlower(new Flower("Orchid1", new Color("Purple"), 12.0, 3, 14));
        bouquet.addFlower(new Flower("Rose2", new Color("White"), 9.0, 6, 17));


        List<Flower> foundFlowers = FlowerFinder.findFlowersInStemLengthRange(bouquet, 13, 16);


        assertEquals(2, foundFlowers.size());
        assertTrue(foundFlowers.contains(bouquet.getFlowers().get(2)));
        assertTrue(foundFlowers.contains(bouquet.getFlowers().get(0)));
    }
}