package flowers;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import colors.Color;

public class RoseTest {
    private Rose rose;

    @BeforeEach
    public void setUp() {
        Color color = new Color("Red");
        rose = new Rose("Red Rose", color, 12.0, 5, 14, 24);
    }

    @Test
    public void testGetNumberOfPetals() {
        assertEquals(24, rose.getNumberOfPetals());
    }

    @Test
    public void testGetName() {
        assertEquals("Red Rose", rose.getName());
    }

    @Test
    public void testGetColor() {
        assertEquals("Red", rose.getColor().getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(12.0, rose.getPrice(), 0.01);
    }

    @Test
    public void testGetFreshnessLevel() {
        assertEquals(5, rose.getFreshnessLevel());
    }

    @Test
    public void testGetStemLength() {
        assertEquals(14, rose.getStemLength());
    }

    @Test
    public void testDescribe() {
        assertDoesNotThrow(() -> rose.describe());
    }
}