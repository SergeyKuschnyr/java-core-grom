package lesson10.HW;

import java.util.Date;

/**
 * Created by Kushn_000 on 21.04.2017.
 */
public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {

        if (this != null) {
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Харьков" || getShipToCity() == "Днепр")
                if (getCustomerOwned().getCity() == "Киев" || getCustomerOwned().getCity() == "Одесса" ||
                        getCustomerOwned().getCity() == "Харьков" || getCustomerOwned().getCity() == "Днепр")
                    if (getBasePrice() >= 100)
                        if (getCustomerOwned().getGender() == "Женский") {
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
            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса")
                setTotalPrice((getBasePrice() + getBasePrice() * 0.1));
            else
                setTotalPrice(getBasePrice() + getBasePrice() * 0.15);
        else
            return;
        if (getTotalPrice() > 1000)
            setTotalPrice(getTotalPrice() - getTotalPrice() * 0.05);
    }

    @Override
    void printInfo() {
        System.out.println("  CustomerCity: " + getCustomerOwned().getCity() + "  CustomerName: " + getCustomerOwned().getName() +
                "  Gender: " + getCustomerOwned().getGender());
        System.out.println("  ItemName: " + getItemName() + "  TotalPrice: " + getBasePrice() +
                "  ShipToCity: " + getShipToCity() + "  Guaranty: " + guaranteeMonths);
    }
}
