package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;

import java.io.File;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoHotel {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        hotelController.getHotelService().getHotelRepository().
                setHotelFile(new File("C:/Lesson35_DBFile/hotelFile.txt"));
        hotelController.getHotelService().getHotelRepository().
                setIDFile(new File("C:/Lesson35_DBFile/IDFile.txt"));

        Hotel hotel1 = new Hotel("Star", "Ukraine", "Kiev", "Vasilkovskaya");
        Hotel hotel2 = new Hotel("Sun", "Germany", "Bonn", "Bakha");
        Hotel hotel3 = new Hotel("Eldorado", "USA", "San-Francisco", "101 avenue");

        hotelController.addHotel(hotel1);
        hotelController.addHotel(hotel2);
        hotelController.addHotel(hotel3);


    }
}
