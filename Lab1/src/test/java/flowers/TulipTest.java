package flowers;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import colors.Color;

public class TulipTest {
    private Tulip tulip;

    @BeforeEach
    public void setUp() {
        Color color = new Color("Yellow");
        tulip = new Tulip("Yellow Tulip", color, 5.0, 4, 12, true);
    }

    @Test
    public void testIsSpringBloomer() {
        assertTrue(tulip.isSpringBloomer());
    }

    @Test
    public void testGetName() {
        assertEquals("Yellow Tulip", tulip.getName());
    }

    @Test
    public void testGetColor() {
        assertEquals("Yellow", tulip.getColor().getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(5.0, tulip.getPrice(), 0.01);
    }

    @Test
    public void testGetFreshnessLevel() {
        assertEquals(4, tulip.getFreshnessLevel());
    }

    @Test
    public void testGetStemLength() {
        assertEquals(12, tulip.getStemLength());
    }

    @Test
    public void testDescribe() {
        assertDoesNotThrow(() -> tulip.describe());
    }
}