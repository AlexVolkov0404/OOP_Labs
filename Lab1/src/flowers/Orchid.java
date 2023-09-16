package flowers;

public class Orchid extends Flower{
    private String species;
    public Orchid(String name, String color, double price, int freshnessLevel, int stemLength,String species) {
        super(name, color, price, freshnessLevel, stemLength);
        this.species = species;
    }
    public String getSpecies() {
        return species;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Species: " + species);
    }
}
