package reader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bouquet.Accessory;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AccessoryDataReaderTest {
    private String testFilename;

    @BeforeEach
    public void setUp() {
        testFilename = "src/test/resources/test_accessories.txt";
        writeTestAccessoriesToFile();
    }

    @Test
    public void testReadAccessoriesFromFile() {
        List<Accessory> accessories = AccessoryDataReader.readAccessoriesFromFile(testFilename);
        assertNotNull(accessories);
        assertEquals(2, accessories.size());


        Accessory firstAccessory = accessories.get(0);
        assertEquals("Gold Ribbon", firstAccessory.getName());
        assertEquals(2.0, firstAccessory.getPrice(), 0.01);


        Accessory secondAccessory = accessories.get(1);
        assertEquals("Silver Bow", secondAccessory.getName());
        assertEquals(1.5, secondAccessory.getPrice(), 0.01);
    }

    private void writeTestAccessoriesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(testFilename))) {
            bw.write("Gold Ribbon,2.0");
            bw.newLine();
            bw.write("Silver Bow,1.5");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}