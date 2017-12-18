package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.io.IOException;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomService {
    RoomRepository roomRepository = new RoomRepository();

    public Map findRooms(Filter filter) throws IOException{
        roomRepository.findRooms(filter);
        return null;
    }
    public void addRoom(Room room) throws IOException{       // Admin
        roomRepository.addRoom(room);
    }
    public void deleteRoom(Room room){    // Admin
        roomRepository.deleteRoom(room);
    }
}
