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
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (price == room.getPrice() && persons == room.getPersons() && city == room.getCityName() &&
                        hotel == room.getHotelName()) {
                    index++;
                }
            }
        }
        if (index != 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] != null) {
                    if (price == rooms[i].getPrice() && persons == rooms[i].getPersons() &&
                            city == rooms[i].getCityName() && hotel == rooms[i].getHotelName()) {
                        resultRoom[i] = rooms[i];
                    }
                }
            }
            return resultRoom;
        }
        return null;
    }

    @Override
    public Room[] getAll() {
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                index++;
            }
        }
        if (index != 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < rooms.length; i++) {
                if (rooms[i] != null)
                    resultRoom[i] = rooms[i];
            }
            return resultRoom;
        }
        return null;
    }

/*    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (price == room.getPrice() && persons == room.getPersons() && city == room.getCityName() &&
                        hotel == room.getHotelName()) {
                    tempRoom[index] = room;
                    index++;
                }
            }
        }
        if (index != 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++) {
                resultRoom[i] = tempRoom[i];
            }
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
        if (index != 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++)
                resultRoom[i] = tempRoom[i];
            return resultRoom;
        }
        return null;
    }*/

}

