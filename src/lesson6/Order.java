package lesson6;

import java.util.Date;

/**
 * Created by Kushn_000 on 28.03.2017.
 */
public class Order {
    /*public static void main(String[] args) {

    }*/

    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Order() {
    }

    void confirmOrder() {
        if (isConfirmed == false) {
            isConfirmed = true;
            dateConfirmed = new Date();
        }
    }

    boolean checkPrice() {
        if (price > 1000)
            return true;
        return false;
    }

    boolean isValidType() {
        if ((type == "Buy") || (type == "Sale"))
            return true;
        return false;
    }
}
