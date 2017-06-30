package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class BookingComAPI implements API {

    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null)
                if (price - 100 <= room.getPrice() && room.getPrice() <= persons + 100
                        && persons == room.getPersons() && city == room.getCityName() && hotel == room.getHotelName()) {
                    tempRoom[index] = room;
                    index++;
                }
        }
        if (index > 0) {
            Room[] resultRoom = new Room[index + 1];
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
