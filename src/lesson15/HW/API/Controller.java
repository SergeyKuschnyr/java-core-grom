package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Controller {
    private API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {
        int tempLength = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null)
                tempLength += api.findRooms(price, persons, city, hotel).length;
        }

        if (tempLength != 0) {
            System.out.println("For your the request nothing find");
            return null;
        }

        Room[] tempRoom = new Room[tempLength];
        int index = 0;
        for (int i = 0; i < apis.length; i++)
            for (int j = 0; apis[i].findRooms(price, persons, city, hotel) != null &&
                    j < apis[i].findRooms(price, persons, city, hotel).length; j++) {
                tempRoom[index] = apis[i].findRooms(price, persons, city, hotel)[j];
                index++;
            }
        return tempRoom;
    }

    public Room[] check(API api1, API api2) {
        int index = 0;
        Room[] rooms = new Room[api1.getAll().length];
        for (Room room : api1.getAll())
            for (Room room1 : api2.getAll())
                if (room.equals(room1)) {
                    rooms[index] = room;
                    index++;
                }
        Room[] rooms1 = new Room[index];
        for (int i = 0; i < rooms1.length; i++)
            rooms1[i] = rooms[i];
        return rooms1;
    }

    public void print(Room[] rooms) {
        if (rooms != null) {
            System.out.println("For your the request was find:");
            for (Room room : rooms)
                if (room != null) {
                    System.out.println("ID: " + room.getId() + "   Город: " + room.getCityName() +
                            "   Отель: " + room.getHotelName() + "   Мест: " + room.getPersons() +
                            "   Стоимость: " + room.getPrice());
                }
        } else
            System.out.println("For your the request nothing find");
    }
}
