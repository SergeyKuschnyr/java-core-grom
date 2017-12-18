package lesson35.controller;

import lesson35.service.OrderService;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class OrderController {
    OrderService orderService = new OrderService();

    public void bookRoom(long roomId, long userId, long hotelId){
        orderService.bookRoom(roomId, userId, hotelId);
    }
    public void cancelReservation(long roomId, long userId){
        orderService.cancelReservation(roomId, userId);
    }
}
