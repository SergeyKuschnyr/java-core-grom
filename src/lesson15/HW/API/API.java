package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public interface API {
    Room[] findRooms(Room room);
    // Room[] findRooms(int price, int persons, String city);
    // Room[] findRooms(int persons, String city);
    Room[] getAll();
}
