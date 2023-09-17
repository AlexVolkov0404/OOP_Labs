package menu;

import bouquet.Accessory;
import bouquet.FlowerBouquet;
import flowers.Flower;
import reader.AccessoryDataReader;
import reader.FlowerDataReader;
import utils.FlowerFinder;
import utils.FlowerSorter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleMenu {
    private Scanner scanner = new Scanner(System.in);
    private List<FlowerBouquet> allBouquets = new ArrayList<>();
    private List<Accessory> accessories;
    private List<Flower> allFlowers;

    public ConsoleMenu() {
        String accessoriesFile = "src/main/resources/accessories.txt";
        accessories = AccessoryDataReader.readAccessoriesFromFile(accessoriesFile);

        String orchidsFile = "src/main/resources/orchids.txt";
        List<Flower> orchids = FlowerDataReader.readFlowersFromFile(orchidsFile);

        String rosesFile = "src/main/resources/roses.txt";
        List<Flower> roses = FlowerDataReader.readFlowersFromFile(rosesFile);

        allFlowers = new ArrayList<>();
        allFlowers.addAll(orchids);
        allFlowers.addAll(roses);
    }

    public void displayMenu() {
        System.out.println("Меню:");
        System.out.println("1. Вивести доступні квіти");
        System.out.println("2. Вивести доступні аксесуари");
        System.out.println("3. Сформувати букет");
        System.out.println("4. Вивести сформовані букети");
        System.out.println("5. Провести сортування квітів у букеті на основі рівня свіжості");
        System.out.println("6. Знайти квітку в букеті, що відповідає заданому діапазону довжин стебел");
        System.out.println("9. Вийти");
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayAvailableFlowers();
                    break;
                case 2:
                    displayAvailableAccessories();
                    break;
                case 3:
                    FlowerBouquet myBouquet = createBouquet();
                    myBouquet.describe();
                    allBouquets.add(myBouquet);
                    break;
                case 4:
                    showAllBouquetsWithNumbers();
                    break;
                case 5:
                    sortFlowersInBouquet();
                    break;
                case 6:
                    findFlowersByStemLength();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    public void displayAvailableFlowers() {
        System.out.println("Доступні квіти:");
        for (int i = 0; i < allFlowers.size(); i++) {
            Flower flower = allFlowers.get(i);
            System.out.println((i + 1) + ". " + flower.getName() + " - " + flower.getColor().getName() + " - " + flower.getStemLength() + " inches - Freshness: " + flower.getFreshnessLevel());
        }
    }

    public void displayAvailableAccessories() {
        System.out.println("Доступні аксесуари:");
        for (int i = 0; i < accessories.size(); i++) {
            Accessory accessory = accessories.get(i);
            System.out.println((i + 1) + ". Аксесуар: " + accessory.getName());
        }
    }

    public FlowerBouquet createBouquet() {
        FlowerBouquet bouquet = new FlowerBouquet();
        int bouquetSize = 0;

        // Вибір та додавання квітів до букету
        while (true) {
            displayAvailableFlowers();
            System.out.println("Оберіть квітку за номером (або введіть 0, щоб завершити вибір):");
            int flowerChoice = scanner.nextInt();

            if (flowerChoice == 0) {
                break;
            } else if (flowerChoice >= 1 && flowerChoice <= allFlowers.size()) {
                bouquet.addFlower(allFlowers.get(flowerChoice - 1));
                bouquetSize++;
                System.out.println("Квітку додано до букету.");
            } else {
                System.out.println("Невірний номер квітки.");
            }
        }

        // Вибір та додавання аксесуарів до букету
        while (true) {
            displayAvailableAccessories();
            System.out.println("Оберіть аксесуар за номером (або введіть 0, щоб завершити вибір):");
            int accessoryChoice = scanner.nextInt();

            if (accessoryChoice == 0) {
                break;
            } else if (accessoryChoice >= 1 && accessoryChoice <= accessories.size()) {
                bouquet.addAccessory(accessories.get(accessoryChoice - 1));
                System.out.println("Аксесуар додано до букету.");
            } else {
                System.out.println("Невірний номер аксесуара.");
            }
        }

        System.out.println("Букет створено!");
        return bouquet;
    }

    public void showAllBouquetsWithNumbers() {
        if (allBouquets.isEmpty()) {
            System.out.println("У вас ще немає створених букетів.");
        } else {
            System.out.println("Список усіх букетів:");
            for (int i = 0; i < allBouquets.size(); i++) {
                System.out.println("Букет " + (i + 1) + ":");
                allBouquets.get(i).describe();
            }
        }
    }

    public void sortFlowersInBouquet() {
        showAllBouquetsWithNumbers();
        if (allBouquets.isEmpty()) {
            System.out.println("Немає букетів для сортування.");
            return;
        }

        System.out.print("Оберіть номер букету для сортування: ");
        int bouquetNumber = scanner.nextInt();

        if (bouquetNumber < 1 || bouquetNumber > allBouquets.size()) {
            System.out.println("Невірний номер букету.");
            return;
        }

        FlowerBouquet selectedBouquet = allBouquets.get(bouquetNumber - 1);
        FlowerSorter.sortFlowersByFreshness(selectedBouquet.getFlowers());
        System.out.println("Букет був відсортований за рівнем свіжості.");
        selectedBouquet.describe();
    }

    public void findFlowersByStemLength() {
        showAllBouquetsWithNumbers();

        if (allBouquets.isEmpty()) {
            System.out.println("Немає букетів для пошуку квітів за довжиною стебла.");
            return;
        }

        System.out.print("Оберіть номер букету для пошуку квітів: ");
        int bouquetNumber = scanner.nextInt();

        if (bouquetNumber < 1 || bouquetNumber > allBouquets.size()) {
            System.out.println("Невірний номер букету.");
            return;
        }

        FlowerBouquet selectedBouquet = allBouquets.get(bouquetNumber - 1);

        int minStemLength;
        int maxStemLength;

        while (true) {
            System.out.print("Введіть мінімальну довжину стебла: ");
            if (scanner.hasNextInt()) {
                minStemLength = scanner.nextInt();
                break; // Введено коректне значення, виходимо з циклу
            } else {
                System.out.println("Помилка! Введіть ціле число для мінімальної довжини стебла.");
                scanner.next(); // Очищаємо буфер введення
            }
        }

        while (true) {
            System.out.print("Введіть максимальну довжину стебла: ");
            if (scanner.hasNextInt()) {
                maxStemLength = scanner.nextInt();
                if (maxStemLength >= minStemLength) {
                    break; // Введено коректне значення, виходимо з циклу
                } else {
                    System.out.println("Помилка! Максимальна довжина стебла повинна бути більшою або рівною мінімальній.");
                }
            } else {
                System.out.println("Помилка! Введіть ціле число для максимальної довжини стебла.");
                scanner.next(); // Очищаємо буфер введення
            }
        }

        List<Flower> foundFlowers = FlowerFinder.findFlowersInStemLengthRange(selectedBouquet, minStemLength, maxStemLength);

        if (foundFlowers.isEmpty()) {
            System.out.println("Квіти за вказаною довжиною стебла не знайдено.");
        } else {
            System.out.println("Знайдені квіти за довжиною стебла:");
            for (int i = 0; i < foundFlowers.size(); i++) {
                System.out.println((i + 1) + ". " + foundFlowers.get(i).getName());
            }
        }
    }

}
