package bouquet;

import static org.junit.jupiter.api.Assertions.*;

import colors.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import flowers.Flower;


public class FlowerBouquetTest {
    private FlowerBouquet bouquet;
    private Flower rose;
    private Accessory ribbon;

    @BeforeEach
    public void setUp() {
        bouquet = new FlowerBouquet();
        Color roseColor = new Color("Red"); // Припустимо, що у вас є клас Color
        rose = new Flower("Red Rose", roseColor, 12.0, 5, 14);
        ribbon = new Accessory("Gold Ribbon", 2.0);
    }

    @Test
    public void testAddFlower() {
        bouquet.addFlower(rose);
        assertEquals(1, bouquet.getFlowers().size());
        assertEquals("Red Rose", bouquet.getFlowers().get(0).getName());
    }

    @Test
    public void testAddAccessory() {
        bouquet.addAccessory(ribbon);
        assertEquals(1, bouquet.getAccessories().size());
        assertEquals("Gold Ribbon", bouquet.getAccessories().get(0).getName());
    }

    @Test
    public void testCalculateTotalPrice() {
        bouquet.addFlower(rose);
        bouquet.addAccessory(ribbon);
        assertEquals(14.0, bouquet.calculateTotalPrice(), 0.01);
    }

    @Test
    public void testDescribe() {
        bouquet.addFlower(rose);
        bouquet.addAccessory(ribbon);
        assertDoesNotThrow(() -> bouquet.describe());
    }
}