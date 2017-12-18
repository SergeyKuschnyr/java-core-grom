package lesson35.controller;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.service.RoomService;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomController {
    RoomService roomService = new RoomService();
    public Map findRooms(Filter filter) throws IOException{
        roomService.findRooms(filter);
        return null;
    }
    public void addRoom(Room room) throws IOException{       // Admin
        roomService.addRoom(room);
    }
    public void deleteRoom(Room room){    // Admin
        roomService.deleteRoom(room);
    }
}
