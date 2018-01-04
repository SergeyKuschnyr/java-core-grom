package lesson35.service;

import lesson35.repository.OrderRepository;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class OrderService {
    OrderRepository orderRepository = new OrderRepository();

    public void bookRoom(long roomId, long userId){
        orderRepository.bookRoom(roomId, userId);
    }
    public void cancelReservation(long roomId, long userId){
        orderRepository.cancelReservation(roomId, userId);
    }
}
