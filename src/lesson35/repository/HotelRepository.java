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
public class HotelRepository extends GeneralRepository{
    private static File hotelDB;

    public static void setHotelFile(File file) {
        hotelDB = file;
    }

    public static File getHotelFile() {
        return hotelDB;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public Hotel addHotel(Hotel hotel) throws Exception {
        if (UserRepository.getUser().getTYPE().equals(UserType.USER_TYPE)){
            throw new Exception("You haven't the right for using this function");
        }
        if (findInHotelDB(hotel, hotelDB)) {
            throw new InstanceAlreadyExistsException("The hotel " + hotel.getName() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hotelDB, true))) {
            bufferedWriter.append(setID()).append(',');
            bufferedWriter.append(hotel.getName()).append(',');
            bufferedWriter.append(hotel.getCountry()).append(',');
            bufferedWriter.append(hotel.getCity()).append(',');
            bufferedWriter.append(hotel.getStreet()).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File " + " not found");
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

    public long deleteHotel(long ID) throws Exception{
        if (UserRepository.getUser().getTYPE().equals(UserType.USER_TYPE)){
            throw new Exception("You haven't the right for using this function");
        }
        return deleteInstance(ID, hotelDB);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map<String, String> findHotelByParam(String param, int x) {
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

    private boolean findInHotelDB(Hotel hotel, File hotelFile) {
        if (hotelFile == null || hotelFile.length() == 0) {
            return false;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hotelFile))) {
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
        } catch (IOException e) {
            System.out.println("findInHotelDB error: Can't read file " + hotelFile.getPath());
        }
        return false;
    }
}
















