package lesson11.HW;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] findRooms(int price, int persons, String city);
    Room[] findRooms(int persons, String city);
    Room[] getAll();
}
