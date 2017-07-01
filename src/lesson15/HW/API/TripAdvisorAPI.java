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
                if (persons - 1 <= room.getPersons() && room.getPersons() <= persons + 1 && price == room.getPrice()
                        && city == room.getCityName() && hotel == room.getHotelName()) {
                    tempRoom[index] = room;
                    index++;
                }
        }
        if (index != 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++)
                if (resultRoom[i] != null)
                    resultRoom[i].equals(tempRoom[i]);
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
                tempRoom[index].equals(room);
                index++;
            }
        }
        if (index > 0) {
            Room[] resultRoom = new Room[index];
            for (int i = 0; i < resultRoom.length; i++)
                if (resultRoom != null)
                    resultRoom[i].equals(tempRoom[i]);
            return resultRoom;
        }
        return null;
    }
}
