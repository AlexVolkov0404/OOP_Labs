package reader;


import flowers.Flower;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FlowerDataReaderTest {

    @Test
    public void testReadFlowersFromFile() {
        String filename = "src/main/resources/orchids.txt";

        List<Flower> flowers = FlowerDataReader.readFlowersFromFile(filename);

        assertNotNull(flowers);
        assertEquals(3, flowers.size());

        Flower flower = flowers.get(0);
        assertEquals("Orchid1", flower.getName());
        assertEquals("Red", flower.getColor().getName());
        assertEquals(19.99, flower.getPrice());
        assertEquals(4, flower.getFreshnessLevel());
        assertEquals(9, flower.getStemLength());

    }
}