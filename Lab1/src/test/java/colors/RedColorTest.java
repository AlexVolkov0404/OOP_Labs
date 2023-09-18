package colors;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RedColorTest {
    @Test
    public void testRedColorConstructor() {
        RedColor red = new RedColor();
        assertEquals("Red", red.getName());
    }
}