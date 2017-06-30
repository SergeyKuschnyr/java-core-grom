package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class GoogleAPI implements API {

    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(Room inputRoom) {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null)
                if (room.equals(inputRoom)) {
                    tempRoom[index] = room;
                    index++;
                }
        }
        if (index > 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++)
                resultRoom[i] = tempRoom[i];
            return resultRoom;
        }
        return null;
    }

    @Override
    public Room[] getAll() {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                tempRoom[index] = room;
                index++;
            }
        }
        if (index > 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++)
                resultRoom[i] = tempRoom[i];
            return resultRoom;
        }
        return null;
    }
}
