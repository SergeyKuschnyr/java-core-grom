package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Controller {
    private API[] apis = new API[3];

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Room[] requestRooms(int price, int persons, String city, String hotel) {

        Room[] rooms = new Room[findRoomsByParams(price, persons, city, hotel)];
        int index = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                for (Room room : api.findRooms(price, persons, city, hotel)) {
                    rooms[index] = room;
                    index++;
                }
            }
        }
        return rooms;

//        int tempLength = 0;
//        for (API api : apis) {
//            if (api.findRooms(price, persons, city, hotel) != null)
//                tempLength += api.findRooms(price, persons, city, hotel).length;
//        }
//
//        if (tempLength != 0) {
//            System.out.println("For your the request nothing find");
//            return null;
//        }
//
//        Room[] tempRoom = new Room[tempLength];
//        int index = 0;
//        for (int i = 0; i < apis.length; i++)
//            for (int j = 0; apis[i].findRooms(price, persons, city, hotel) != null &&
//                    j < apis[i].findRooms(price, persons, city, hotel).length; j++) {
//                tempRoom[index] = apis[i].findRooms(price, persons, city, hotel)[j];
//                index++;
//            }
//        return tempRoom;
    }

    private int findRoomsByParams(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) {
                count += api.findRooms(price, persons, city, hotel).length;
            }
        }
        return count;
    }

    private Room[] findCommonRooms(Room[] roomsAPI1, Room[] roomsAPI2) {
        int count = 0;
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (roomAPI1.equals(roomAPI2)) {
                    count++;
                }
            }
        }

        Room[] res = new Room[count];
        int index = 0;
        for (Room roomAPI1 : roomsAPI1) {
            for (Room roomAPI2 : roomsAPI2) {
                if (roomAPI1.equals(roomAPI2)) {
                    res[index] = roomAPI1;
                }
            }
        }
        return res;
    }

    public Room[] check(API api1, API api2) {

        if (api1 != null && api2 != null)
            return findCommonRooms(api1.getAll(), api2.getAll());

//        int index = 0;
//        if (api1 != null && api1.getAll() != null) {
//            for (Room room : api1.getAll()) {
//                for (Room room1 : api2.getAll()) {
//                    if (room.equals(room1)) {
//                        index++;
//                    }
//                }
//            }
//            Room[] returnRooms = new Room[index];
//            int i = 0;
//            for (Room room : api1.getAll()) {
//                for (Room room1 : api2.getAll()) {
//                    if (room.equals(room1)) {
//                        returnRooms[i] = room1;
//                        i++;
//                    }
//                }
//            }
//            return returnRooms;
//        }
        return new Room[0];
    }

//    public Room[] check(API api1, API api2) {
//        int index = 0;
//        if (api1 != null && api1.getAll() != null) {
//            Room[] tempRooms = new Room[api1.getAll().length];
//            for (Room room : api1.getAll()) {
//                for (Room room1 : api2.getAll()){
//                    if (room.equals(room1)) {
//                        tempRooms[index] = room;
//                        index++;
//                    }
//                }
//            }
//            Room[] returnRooms = new Room[index];
//            for (int i = 0; i < returnRooms.length; i++){
//                returnRooms[i] = tempRooms[i];
//            }
//            return returnRooms;
//        }
//        return null;
//    }

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
