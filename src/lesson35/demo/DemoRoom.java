package lesson35.demo;

import lesson35.controller.RoomController;
import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.repository.GeneralRepository;
import lesson35.repository.HotelRepository;
import lesson35.repository.UserRepository;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class DemoRoom {
    public static void main(String[] args) {
        RoomController roomController = new RoomController();
        HotelRepository.setHotelDB(new File("C:/Lesson35_DBFile/hotelDB.txt"));
        roomController.getRoomService().getRoomRepository().setRoomDB(new File("C:/Lesson35_DBFile/roomDB.txt"));
        //(new UserRepository()).setUserDB(new File((new UserRepository()).getPath().toString()));

        Hotel hotel11 = new Hotel("Hollywood", "USA", "Los Angeles", "67 avenue");
        hotel11.setId(107);
        Hotel hotel1 = new Hotel("Star", "Ukraine", "Kiev", "Vasilkovskaya");
        hotel1.setId(108);
        Hotel hotel2 = new Hotel("Sun", "Germany", "Bonn", "Bakha");
        hotel2.setId(109);
        Hotel hotel3 = new Hotel("Eldorado", "USA", "San Francisco", "101 avenue");
        hotel3.setId(104);
        //Hotel hotel4 = new Hotel("Star", "Germany", "Bonn", "Gete");

//        HotelRepository hotelRepository = new HotelRepository();
//        ArrayList hotelsAL = hotelRepository.mapping(new File("C:/Lesson35_DBFile/hotelDB.txt"));

        Room room1 = new Room(2, 20, false, false,
                new Date(2017, 12, 17), hotel1);
        Room room2 = new Room(2, 30, true, false,
                new Date(2017, 12, 27), hotel2);
        Room room3 = new Room(4, 50, false, false,
                new Date(2017, 12, 25), hotel3);
        Room room4 = new Room(3, 40, true,true,
                new Date(2017, 12,27), (Hotel) hotel11);

        try {
            roomController.addRoom(room1);
            roomController.addRoom(room2);
            roomController.addRoom(room3);
            roomController.addRoom(room4);
            roomController.deleteRoom(room3.getId());
        } catch (Exception e) {
            System.out.println("ERRROR " + e.getMessage());
        }


        Filter filter = new Filter(2, 20,false, false,
                new Date(2017, 12, 17), "USA", "San Francisco");

        try {
            System.out.println("TEST: " + (roomController.findRooms(filter)));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}





