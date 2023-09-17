package flowers;

import colors.Color;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTest {
    private Flower flower;

    @BeforeEach
    public void setUp() {
        colors.Color color = new Color("Red");

        flower = new Flower("Rose", color, 10.0, 5, 12);
    }

    @Test
    public void testGetName() {
        assertEquals("Rose", flower.getName());
    }

    @Test
    public void testGetColor() {
        assertEquals("Red", flower.getColor().getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(10.0, flower.getPrice(), 0.01); // Перевірка з допустимою похибкою
    }

    @Test
    public void testGetFreshnessLevel() {
        assertEquals(5, flower.getFreshnessLevel());
    }

    @Test
    public void testGetStemLength() {
        assertEquals(12, flower.getStemLength());
    }

    @Test
    public void testDescribe() {
        // Для методу describe() ми можемо перенаправити вивід на консоль і перевірити його вміст
        assertDoesNotThrow(() -> flower.describe());
    }
}