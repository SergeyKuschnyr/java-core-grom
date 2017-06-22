package lesson6;

/**
 * Created by Kushn_000 on 28.03.2017.
 */
public class Car {
    //1 fields
    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    //2 constructots

    public Car(int price, int yearOfManufacturing, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

    //3 metods
    void startRun() {
        System.out.println("I am running....");
    }

    void stopRun() {
        System.out.println("I am stopping....");
    }

    void changeOwner(String newOwnerName) {
        ownerName = newOwnerName;
    }
}
