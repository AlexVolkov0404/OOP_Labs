package flowers;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import colors.Color;

public class OrchidTest {
    private Orchid orchid;

    @BeforeEach
    public void setUp() {
        Color color = new Color("Purple");
        orchid = new Orchid("Phalaenopsis", color, 15.0, 4, 10, "Phalaenopsis amabilis");
    }

    @Test
    public void testGetSpecies() {
        assertEquals("Phalaenopsis amabilis", orchid.getSpecies());
    }

    @Test
    public void testGetName() {
        assertEquals("Phalaenopsis", orchid.getName());
    }

    @Test
    public void testGetColor() {
        assertEquals("Purple", orchid.getColor().getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(15.0, orchid.getPrice(), 0.01);
    }

    @Test
    public void testGetFreshnessLevel() {
        assertEquals(4, orchid.getFreshnessLevel());
    }

    @Test
    public void testGetStemLength() {
        assertEquals(10, orchid.getStemLength());
    }

    @Test
    public void testDescribe() {
        assertDoesNotThrow(() -> orchid.describe());
    }
}