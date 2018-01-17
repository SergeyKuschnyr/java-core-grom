package lesson35.controller;

import lesson35.model.Hotel;
import lesson35.service.HotelService;

import javax.management.InstanceAlreadyExistsException;
import java.io.File;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class HotelController {
    HotelService hotelService = new HotelService();

    public HotelService getHotelService() {
        return hotelService;
    }

    public Map findHotelByName(String name){
        return hotelService.findHotelByName(name);
    }

    public Map findHotelByCity(String city){
        return hotelService.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        return hotelService.addHotel(hotel);
    }

    public long deleteHotel(long hotel) throws Exception{
        return hotelService.deleteHotel(hotel);
    }

}
