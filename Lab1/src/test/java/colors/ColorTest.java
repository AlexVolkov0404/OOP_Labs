package colors;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ColorTest {
    @Test
    public void testGetName() {
        Color color = new Color("Red");
        assertEquals("Red", color.getName());
    }
}