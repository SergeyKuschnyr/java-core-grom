package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import javax.management.InstanceAlreadyExistsException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomController {
    RoomService roomService = new RoomService();

    public RoomService getRoomService() {
        return roomService;
    }

    public Map findRooms(Filter filter) {
        roomService.findRooms(filter);
        return null;
    }
    public void addRoom(Room room) throws InstanceAlreadyExistsException{       // Admin
        roomService.addRoom(room);
    }
    public void deleteRoom(long ID){    // Admin
        roomService.deleteRoom(ID);
    }
}
