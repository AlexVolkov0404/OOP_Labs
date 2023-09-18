package colors;
import static org.junit.jupiter.api.Assertions.*;
import colors.WhiteColor;
import org.junit.jupiter.api.Test;

public class WhiteColorTest {
    @Test
    public void testWhiteColorConstructor() {
        WhiteColor white = new WhiteColor();
        assertEquals("White", white.getName());
    }
}