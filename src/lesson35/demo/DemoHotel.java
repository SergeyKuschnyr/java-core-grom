package lesson35.demo;

import lesson35.controller.HotelController;
import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;
import lesson35.repository.UserRepository;

import java.io.File;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoHotel {
    public static void main(String[] args) {

        HotelController hotelController = new HotelController();
        HotelRepository.setHotelDB(new File("C:/Lesson35_DBFile/hotelDB.txt"));
        (new UserRepository()).setUserDB(new File((new UserRepository()).getPath().toString()));

        Hotel hotel1 = new Hotel("Star", "Ukraine", "Kiev", "Vasilkovskaya");
        Hotel hotel2 = new Hotel("Sun", "Germany", "Bonn", "Bakha");
        Hotel hotel3 = new Hotel("Eldorado", "USA", "San Francisco", "101 avenue");
        Hotel hotel4 = new Hotel("Star", "Germany", "Bonn", "Gete");

        try {
            hotelController.addHotel(hotel1);
            hotelController.addHotel(hotel2);
            hotelController.addHotel(hotel3);

            hotelController.deleteHotel(hotel3.getId());

            hotelController.addHotel(hotel3);
            hotelController.addHotel(hotel4);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        System.out.println(hotelController.findHotelByName("Star"));
        System.out.println(hotelController.findHotelByCity("Bonn"));
    }
}







