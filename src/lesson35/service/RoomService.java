package lesson35.service;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import javax.management.InstanceAlreadyExistsException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomService {
    RoomRepository roomRepository = new RoomRepository();

    public RoomRepository getRoomRepository() {
        return roomRepository;
    }

    public Map findRooms(Filter filter) throws Exception{
        return roomRepository.findRooms(filter);
    }
    public Room addRoom(Room room) throws Exception{
        return roomRepository.addRoom(room);
    }
    public long deleteRoom(long ID) throws Exception{
        return roomRepository.deleteRoom(ID);
    }
}
