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
            String tempString = setID();
            bufferedWriter.append(tempString).append(',');
            hotel.setId(Long.parseLong(tempString));///////////////////////////////////////////
            bufferedWriter.append(hotel.getName()).append(',');
            bufferedWriter.append(hotel.getCountry()).append(',');
            bufferedWriter.append(hotel.getCity()).append(',');
            bufferedWriter.append(hotel.getStreet()).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File " + hotelDB.getPath() + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to DBFile");
        }
        return hotel;
    }

    public Map findHotelByName(String name) {
        return findHotelByParam(name);
    }

    public Map findHotelByCity(String city) {
        return findHotelByParam(city);
    }

    public long deleteHotel(long ID) throws Exception {
        if (userTypeValidate().equals((UserType.USER_TYPE).toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        return DBUpdate(ID, hotelDB);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, Hotel> findHotelByParam(String param) {
        if (param == null) {
            return new HashMap<>();
        }
        if (hotelDB == null || (hotelDB.length() == 0)) {
            return new HashMap<>();
        }
        Map<String, Hotel> hotelsByParam = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hotelDB.getPath()))) {

            readingOfDB(bufferedReader, hotelsByParam);
            hotelsByParam.putAll(findByParam(hotelsByParam, param));

        } catch (FileNotFoundException e) {
            System.out.println("File " + hotelDB + "no exist");
        } catch (IOException e) {
            System.out.println("Can't read file " + hotelDB);
        }
        return hotelsByParam;
    }

    private void readingOfDB(BufferedReader bufferedReader, Map hotelsByParam) throws IOException{
        String nameTemp;
        while ((nameTemp = bufferedReader.readLine()) != null) {
            String[] hotelDescription = nameTemp.split(",");
            mapping(hotelDescription, hotelsByParam);
        }
    }

    private void mapping(String[] strings, Map hotelsByParam){
        Hotel hotel = new Hotel(strings[0], strings[1], strings[2], strings[3]);
        hotelsByParam.put(strings[0], hotel);
    }

    private Map<String, Hotel> findByParam(Map<String, Hotel> hotelsByParam, String param){
        Map<String, Hotel> hotelMap = new HashMap<>();
        for (Hotel hotel : hotelsByParam.values()){
            if (hotel.getName().equals(param) || hotel.getCity().equals(param)){
                hotelMap.put(hotel.getName(), hotel);
            }
        }
        hotelsByParam.clear();
        return hotelMap;
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
                     new BufferedReader(new FileReader(new File((new UserRepository()).getPath().toString())))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings.length == 6){
                    return strings[4];
                }
            }
            throw new Exception("Please login");
        } catch (IOException e) {
            System.out.println("Can't read from file: " + (new UserRepository()).getPath().toString());
        }
        return null;
    }
}
















