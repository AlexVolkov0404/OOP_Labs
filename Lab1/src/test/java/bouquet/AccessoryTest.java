package bouquet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AccessoryTest {
    private Accessory accessory;

    @BeforeEach
    public void setUp() {
        accessory = new Accessory("Gold Ribbon", 2.0);
    }

    @Test
    public void testGetName() {
        assertEquals("Gold Ribbon", accessory.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(2.0, accessory.getPrice(), 0.01);
    }
}