package lesson35.service;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class HotelService {
    HotelRepository hotelRepository = new HotelRepository();

    public HotelRepository getHotelRepository() {
        return hotelRepository;
    }

    public Map findHotelByName(String name){
        return hotelRepository.findHotelByName(name);
    }
    public Map findHotelByCity(String city){
        return hotelRepository.findHotelByCity(city);
    }
    public Hotel addHotel(Hotel hotel){      //admin
        return hotelRepository.addHotel(hotel);
    }
    public long deleteHotel(long hotel){   //admin
        return hotelRepository.deleteHotel(hotel);
    }
}
