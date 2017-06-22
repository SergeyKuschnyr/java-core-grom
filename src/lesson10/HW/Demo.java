package lesson10.HW;

import java.util.Date;

/**
 * Created by Kushn_000 on 22.04.2017.
 */
public class Demo {
    public static void main(String[] args) {

        Customer customer = new Customer("Олег", "Львов", "male");
        Customer customer2 = new Customer("Анна", "Киев", "female");

        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Router", new Date(), "Киев", 1500, customer, 12);
        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Printer Server", new Date(), "Одесса", 1700, customer2, 24);

        FurnitureOrder furnitureOrder = new FurnitureOrder("Bushing", new Date(), "Днепр", 5500, customer, "1234567");
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Lever", new Date(), "Львов", 5900, customer2, "1234321");

        electronicsOrder.calculatePrice();
        electronicsOrder.validateOrder();
        electronicsOrder.confirmedShipped();
        electronicsOrder.printInfo();
        System.out.println();

        electronicsOrder2.calculatePrice();
        electronicsOrder2.validateOrder();
        electronicsOrder2.confirmedShipped();
        electronicsOrder2.printInfo();
        System.out.println();

        furnitureOrder.calculatePrice();
        furnitureOrder.validateOrder();
        furnitureOrder.confirmedShipped();
        furnitureOrder.printInfo();
        System.out.println();

        furnitureOrder2.calculatePrice();
        furnitureOrder2.validateOrder();
        furnitureOrder2.confirmedShipped();
        furnitureOrder2.printInfo();
    }

}
