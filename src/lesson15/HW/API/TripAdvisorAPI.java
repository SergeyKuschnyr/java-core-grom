package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class TripAdvisorAPI implements API {

    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null)
                if ((price - 10) <= room.getPrice() && room.getPrice() <= (price + 10) &&
                        (persons - 1) <= room.getPersons() && room.getPersons() <= (persons + 1) &&
                        room.getCityName() == city && room.getHotelName() == hotel) {
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

    public Room[] findRooms(int price, int persons, String city) {
        return null;
    }

    public Room[] findRooms(int persons, String city) {
        Room[] tempRoom = new Room[rooms.length];
        int index = 0;
        for (Room room : rooms) {
            if (room != null)
                if (room.getPersons() == persons && room.getCityName() == city) {
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
