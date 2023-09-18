package menu;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import bouquet.FlowerBouquet;
import colors.Color;
import flowers.Flower;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

public class ConsoleMenuTest {
    private ConsoleMenu consoleMenu;

    @BeforeEach
    public void setUp() {
        consoleMenu = new ConsoleMenu();
    }

    @Test
    public void testCreateBouquet() {
        FlowerBouquet bouquet = new FlowerBouquet();
        bouquet.addFlower(new Flower("Rose", new Color("Red"), 10.0, 5, 15));
        assertNotNull(bouquet);
        assertEquals(1, bouquet.getFlowers().size());
        assertEquals(0, bouquet.getAccessories().size());
    }

    @Test
    public void testSortFlowersInBouquet() {
        // Підготовка тестового букету для сортування
        FlowerBouquet bouquet = new FlowerBouquet();
        bouquet.addFlower(new Flower("Rose", new Color("Red"), 10.0, 5, 15));
        bouquet.addFlower(new Flower("Tulip", new Color("Yellow"), 8.0, 4, 12));
        bouquet.addFlower(new Flower("Orchid", new Color("Purple"), 12.0, 3, 14));

        // Сортування квітів у букеті за рівнем свіжості
        consoleMenu.sortFlowersInBouquet();

        List<Flower> sortedFlowers = bouquet.getFlowers();
        assertEquals(3, sortedFlowers.size());
        assertEquals("Rose", sortedFlowers.get(0).getName());
        assertEquals("Tulip", sortedFlowers.get(1).getName());
        assertEquals("Orchid", sortedFlowers.get(2).getName());
    }

    @Test
    public void testFindFlowersByStemLength() {
        // Підготовка тестового букету для пошуку
        FlowerBouquet bouquet = new FlowerBouquet();
        bouquet.addFlower(new Flower("Rose", new Color("Red"), 10.0, 5, 15));
        bouquet.addFlower(new Flower("Tulip", new Color("Yellow"), 8.0, 4, 12));
        bouquet.addFlower(new Flower("Orchid", new Color("Purple"), 12.0, 3, 14));

        // Встановлюємо введення для тесту пошуку
        String input = "2\n1\n15\n12\n"; // Вибираємо букет №2, встановлюємо діапазон довжин стебел
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        consoleMenu.findFlowersByStemLength();

        List<Flower> foundFlowers = bouquet.getFlowers();
        assertEquals(3, foundFlowers.size());
        assertEquals("Rose", foundFlowers.get(0).getName());
        assertEquals("Tulip", foundFlowers.get(1).getName());
    }
}