package flowers;

import colors.Color;

public class Sunflower extends Flower{
    private double seedSizeInInches;
    public Sunflower(String name, Color color, double price, int freshnessLevel, int stemLength, double seedSizeInInches) {
        super(name, color, price, freshnessLevel, stemLength);
        this.seedSizeInInches = seedSizeInInches;
    }
    public double getSeedSizeInInches() {
        return seedSizeInInches;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Seed Size (in inches): " + seedSizeInInches);
    }
}
