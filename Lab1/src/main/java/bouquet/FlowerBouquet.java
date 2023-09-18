package bouquet;

import flowers.Flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerBouquet {
    private List<Flower> flowers;
    private List<Accessory> accessories;

    public FlowerBouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void addAccessory(Accessory accessory) {
        accessories.add(accessory);
    }

    public double calculateTotalPrice() {
        double flowerPrice = flowers.stream().mapToDouble(Flower::getPrice).sum();
        double accessoryPrice = accessories.stream().mapToDouble(Accessory::getPrice).sum();
        return flowerPrice + accessoryPrice;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void describe() {
        System.out.println("Bouquet Contents:");
        for (Flower flower : flowers) {
            System.out.println("Flower: " + flower.getName());
        }
        for (Accessory accessory : accessories) {
            System.out.println("Accessory: " + accessory.getName());
        }
        System.out.println("Total Price: " + calculateTotalPrice());
    }
}
