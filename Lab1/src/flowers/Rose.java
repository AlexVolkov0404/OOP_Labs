package flowers;

public class Rose extends Flower{
    private int numberOfPetals;
    public Rose(String name, String color, double price, int freshnessLevel, int stemLength,int numberOfPetals) {
        super(name, color, price, freshnessLevel, stemLength);
        this.numberOfPetals = numberOfPetals;
    }
    public int getNumberOfPetals() {
        return numberOfPetals;
    }
    @Override
    public void describe() {
        super.describe();
        System.out.println("Number of Petals: " + numberOfPetals);
    }
}
