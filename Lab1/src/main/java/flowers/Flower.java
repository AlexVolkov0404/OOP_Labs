package flowers;
import colors.Color;

public class Flower {
    private String name;
    private Color color;
    private double price;
    private int freshnessLevel;
    private int stemLength;

    public Flower(String name, Color color, double price, int freshnessLevel, int stemLength) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshnessLevel() {
        return freshnessLevel;
    }

    public int getStemLength() {
        return stemLength;
    }

    // Method to describe the flower
    public void describe() {
        System.out.print("Name: " + name + " ");
        System.out.print("Color: " + color.getName() + " ");
        System.out.print("Height (in inches): " + stemLength + " ");
        System.out.print("Fragrance: " + freshnessLevel + " ");
    }
}