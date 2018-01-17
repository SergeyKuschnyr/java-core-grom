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
        return findHotelByParam(name, 1);
    }

    public Map findHotelByCity(String city) {
        return findHotelByParam(city, 3);
    }

    public long deleteHotel(long ID) throws Exception {
        if (userTypeValidate().equals((UserType.USER_TYPE).toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        return fileUpdate(ID, hotelDB);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, String> findHotelByParam(String param, int x) {
        if (param == null) {
            return new HashMap<>();
        }
        if (hotelDB == null || (hotelDB.length() == 0)) {
            return new HashMap<>();
        }
        Map<String, String> hotelsByParam = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hotelDB.getPath()))) {
            String nameTemp;
            while ((nameTemp = bufferedReader.readLine()) != null) {
                String[] hotelDescription = nameTemp.split(",");
                if (hotelDescription[x].equals(param)) {
                    hotelsByParam.put(hotelDescription[0], param);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + hotelDB + "no exist");
        } catch (IOException e) {
            System.out.println("Can't read file " + hotelDB);
        }
        return hotelsByParam;
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
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(UserRepository.getUserDB()))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings.length == 6){
                    return strings[4];
                }
            }
            throw new Exception("Please login");
        } catch (IOException e) {
            System.out.println("Can't read from file: " + UserRepository.getUserDB().getPath());
        }
        return null;
    }
}
















