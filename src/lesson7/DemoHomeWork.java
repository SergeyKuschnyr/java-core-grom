package lesson7;

import java.util.Date;

/**
 * Created by Kushn_000 on 01.04.2017.
 */
public class DemoHomeWork {

    public DemoHomeWork() {
    }

    Order createOrder(){
        return new Order(100, new Date(), false, null, "Dnepr", "Ukraine", "Buy");
    }

    Order createOrderAndCallMethods(){
        Order order = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
        order.confirmOrder();
        order.checkPrice();
        order.isValidType();
        return order;
    }
}
