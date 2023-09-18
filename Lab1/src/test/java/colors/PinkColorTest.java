package colors;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PinkColorTest {
    @Test
    public void testPinkColorConstructor() {
        PinkColor pink = new PinkColor();
        assertEquals("Pink", pink.getName());
    }
}