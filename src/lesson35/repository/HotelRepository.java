package lesson35.repository;

import lesson35.model.Hotel;
import lesson35.model.UserType;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.util.*;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class HotelRepository extends GeneralRepository {
    private static File hotelDB;

    public static void setHotelDB(File file) {
        hotelDB = file;
    }

    public static File getHotelDB() {
        return hotelDB;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public Hotel addHotel(Hotel hotel) throws Exception {
        if (validator(hotel)) {
            throw new InstanceAlreadyExistsException("The hotel " + hotel.getName() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hotelDB, true))) {
            hotel.setId(Long.parseLong(setID()));
            bufferedWriter.append(hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                    hotel.getCity() + "," + hotel.getStreet()).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File " + hotelDB.getPath() + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to DBFile: " + hotelDB.getPath());
        }
        return hotel;
    }

    public Map findHotelByName(String name) {
        try {
            return findHotelByParam(name);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Map findHotelByCity(String city) {
        try {
            return findHotelByParam(city);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    public long deleteHotel(long ID) throws Exception {
        if (userTypeValidate().equals((UserType.USER_TYPE).toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hotelDB, true))) {
            for (Hotel hotel : deleteHotelFromDB(mapping(readingOfDB(hotelDB)), ID).values()) {
                bufferedWriter.append(hotel.getId() + "," + hotel.getName() + "," + hotel.getCountry() + "," +
                        hotel.getCity() + "," + hotel.getStreet()).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Can't write to DBFile: " + hotelDB.getPath());
        }
        return ID;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, Hotel> findHotelByParam(String param) throws Exception{
        if (param == null) {
            return new HashMap<>();
        }
        if (hotelDB == null || (hotelDB.length() == 0)) {
            return new HashMap<>();
        }
        Map<String, Hotel> hotelsByParam = new HashMap<>();
        for (Hotel hotel : mapping(readingOfDB(hotelDB)).values()) {
            if (hotel.getName().equals(param) || hotel.getCity().equals(param)) {
                hotelsByParam.put(hotel.getName(), hotel);
            }
        }
        if (hotelsByParam.size() == 0){
            throw new Exception("Your request nothing return");
        }
        return hotelsByParam;
    }

    private Map<String, Hotel> mapping(StringBuilder stringBuilder) {
        Map<String, Hotel> instanceDB = new HashMap();
        String s = stringBuilder.toString();
        String[] strings = s.split("\\n");
        for (String str : strings) {
            String[] strg = str.split(",");
            Hotel hotel = new Hotel(strg[1], strg[2], strg[3], strg[4]);
            hotel.setId(Long.parseLong(strg[0]));
            instanceDB.put(strg[0], hotel);
        }
        return instanceDB;
    }

    private Map<String, Hotel> deleteHotelFromDB(Map<String, Hotel> hotelInstanceDB, long id) throws Exception {
        for (Hotel hotel : hotelInstanceDB.values()) {
            if (hotel.getId() == id) {
                hotelInstanceDB.remove(hotel.getName());
                return hotelInstanceDB;
            }
        }
        throw new Exception("The recording with id " + id + "not found");
    }

    private boolean validator(Hotel hotel) throws Exception {
        if (userTypeValidate().equals((UserType.USER_TYPE).toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        if (hotel == null) {
            throw new Exception("Input date error");
        }
        if (hotelDB == null) {
            throw new Exception("Can't find DB or one is empty");
        }
        if (hotelDB.length() == 0) {
            return false;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hotelDB))) {
            String hotelString;
            while ((hotelString = bufferedReader.readLine()) != null) {
                String[] hotelArr = hotelString.split(",");
                if (hotelArr[1].equals(hotel.getName()) &&
                        hotelArr[2].equals(hotel.getCountry()) &&
                        hotelArr[3].equals(hotel.getCity()) &&
                        hotelArr[4].equals(hotel.getStreet())) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            System.out.println("Can't read from file " + hotelDB.getPath());
        }
        return false;
    }

    public String userTypeValidate() throws Exception {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader(new File((new UserRepository()).getPath())))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings.length == 6) {
                    return strings[4];
                }
            }
            throw new Exception("Please login");
        } catch (IOException e) {
            System.out.println("Can't read from file: " + (new UserRepository()).getPath());
        }
        return null;
    }
}
















