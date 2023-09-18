package flowers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import colors.Color;

public class SunflowerTest {
    private Sunflower sunflower;

    @BeforeEach
    public void setUp() {
        Color color = new Color("Yellow"); // Припустимо, що у вас є клас Color
        sunflower = new Sunflower("Yellow Sunflower", color, 8.0, 4, 20, 0.5);
    }

    @Test
    public void testGetSeedSizeInInches() {
        assertEquals(0.5, sunflower.getSeedSizeInInches(), 0.01);
    }

    @Test
    public void testGetName() {
        assertEquals("Yellow Sunflower", sunflower.getName());
    }

    @Test
    public void testGetColor() {
        assertEquals("Yellow", sunflower.getColor().getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(8.0, sunflower.getPrice(), 0.01);
    }

    @Test
    public void testGetFreshnessLevel() {
        assertEquals(4, sunflower.getFreshnessLevel());
    }

    @Test
    public void testGetStemLength() {
        assertEquals(20, sunflower.getStemLength());
    }

    @Test
    public void testDescribe() {
        assertDoesNotThrow(() -> sunflower.describe());
    }
}