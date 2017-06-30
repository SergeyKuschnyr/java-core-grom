package lesson15.HW.API;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public interface API {
    Room[] findRooms(int price, int persons, String city, String hotel);
    Room[] getAll();
}
