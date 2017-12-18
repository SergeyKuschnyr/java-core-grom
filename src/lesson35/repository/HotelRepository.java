package lesson35.repository;

import lesson35.model.Hotel;

import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class HotelRepository extends GeneralRepository{
    private File hotelFile;
    private File IDFile;

    public void setHotelFile(File file) {
        this.hotelFile = file;
    }

    public void setIDFile(File file) {
        this.IDFile = file;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(IDFile))){
            bufferedWriter.append("100");
        }catch (IOException e){
            System.out.println("Can't write to the file " + IDFile.getPath());
        }
    }

    public File getHotelFile() {
        return hotelFile;
    }

    public File getIDFile() {
        return IDFile;
    }

    public Map findHotelByName(String name) {
        return findHotelByParam(name, 1);
    }

    public Map findHotelByCity(String city) {
        return findHotelByParam(city, 3);
    }

    public Hotel addHotel(Hotel hotel) {      //admin
        return add(hotel, hotelFile, IDFile);
    }

    public long deleteHotel(long hotelID) {   //admin
        return delete(hotelID, hotelFile);
    }

    private Map<String, String> findHotelByParam(String param, int x){
        if (hotelFile == null || (hotelFile.length() == 0)) {
            return new HashMap<>();
        }
        Map<String, String> hotelsByParam = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hotelFile.getPath()))) {
            String nameTemp;
            while ((nameTemp = bufferedReader.readLine()) != null) {
                String[] hotelDescription = param.split(",");
                if (hotelDescription[x].equals(param)) {
                    hotelsByParam.put(param, hotelDescription[0]);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + hotelFile + "no exist");
        } catch (IOException e) {
            System.out.println("Can't read file " + hotelFile);
        }
        return hotelsByParam;
    }
}









