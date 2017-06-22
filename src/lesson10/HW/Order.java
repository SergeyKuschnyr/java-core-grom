package lesson10.HW;

import java.util.Date;

/**
 * Created by Kushn_000 on 21.04.2017.
 */
public abstract class Order {
    private String itemName;
    private Date dateCreated;
    private Date dateConfirmed;
    private Date dateShipped;
    private String shipToCity;
    private int basePrice;
    private double totalPrice;
    private Customer customerOwned;

    public Order(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreated = dateCreated;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }

    abstract void validateOrder();

    abstract void calculatePrice();

    void confirmedShipped() {
        if (this != null) {
            if (dateShipped == null)
                dateShipped = new Date();
        } else
            return;
        System.out.println("DateShipped: " + dateShipped);
    }

    void test() {
        calculatePrice();
        validateOrder();
        confirmedShipped();
    }

    abstract void printInfo();
}
