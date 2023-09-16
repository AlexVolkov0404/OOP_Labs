package flowers;

public class Tulip extends Flower{
    private boolean isSpringBloomer;
    public Tulip(String name, String color, double price, int freshnessLevel, int stemLength,boolean isSpringBloomer) {
        super(name, color, price, freshnessLevel, stemLength);
        this.isSpringBloomer = isSpringBloomer;
    }
    public boolean isSpringBloomer() {
        return isSpringBloomer;
    }

    @Override
    public void describe() {
        super.describe();
        System.out.println("Blooms in Spring: " + (isSpringBloomer ? "Yes" : "No"));
    }
}
