package flowers;

public  class Flower {
    private String name;
    private String color;
    private double price;
    private int freshnessLevel;
    private int stemLength;

    public Flower(String name, String color, double price, int freshnessLevel, int stemLength) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
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
        System.out.println("Name: " + name);
        System.out.println("Color: " + color);
        System.out.println("Height (in inches): " + stemLength);
        System.out.println("Fragrance: " + freshnessLevel);
    }

}
