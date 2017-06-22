package lesson10.HW;

import java.util.Date;

/**
 * Created by Kushn_000 on 21.04.2017.
 */
public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (this != null) {
            if (getCustomerOwned().getCity() == "Киев" || getCustomerOwned().getCity() == "Львов")
                if (getBasePrice() >= 500)
                    if (getCustomerOwned().getName() != "Тест") {
                        setDateConfirmed(new Date());
                        return;
                    }
        } else
            return;
        System.out.println("Order is not validate");
    }

    @Override
    public void calculatePrice() {
        if (this != null)
            if (getBasePrice() < 5000)
                setTotalPrice(getBasePrice() + getBasePrice() * 0.05);
            else
                setTotalPrice(getBasePrice() + getBasePrice() * 0.02);
    }

    @Override
    void printInfo() {
        System.out.println("  CustomerCity: " + getCustomerOwned().getCity() + "  CustomerName: " + getCustomerOwned().getName() +
                "  Gender: " + getCustomerOwned().getGender());
        System.out.println("  ItemName: " + getItemName() + "  TotalPrice: " + getBasePrice() +
                "  ShipToCity: " + getShipToCity() + "  FurnitureCode: " + furnitureCode);
    }
}
