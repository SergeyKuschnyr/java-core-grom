package lesson35.demo;

import lesson35.controller.OrderController;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoOrder {
    public static void main(String[] args) {
        OrderController orderController = new OrderController();

        try {
            orderController.bookRoom(123, 456);
            orderController.bookRoom(12, 45);

            orderController.cancelReservation(123, 456);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
