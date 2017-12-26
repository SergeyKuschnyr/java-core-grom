package lesson35.repository;

import lesson35.model.Room;

import java.io.File;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class OrderRepository {
    private File orderDB;
    private RoomRepository roomRepository;

    public void bookRoom(long roomId, long userId, long hotelId) {

    }

    public void cancelReservation(long roomId, long userId) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    private void inputValidator(long roomId, long userId, long hotelId) {

    }
}
