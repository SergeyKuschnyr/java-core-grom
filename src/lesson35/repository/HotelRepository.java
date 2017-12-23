package lesson35.repository;

import lesson35.model.Hotel;
import org.apache.commons.io.FileUtils;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class HotelRepository extends GeneralRepository{
    private static File staticHotelFile;
    private File hotelIDFile;

    public static void setHotelFile(File file) {
        staticHotelFile = file;
    }

    public void setHotelIDFile(File file) {
        this.hotelIDFile = file;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(hotelIDFile))) {
            bufferedWriter.append("100");
        } catch (IOException e) {
            System.out.println("Can't write to the file " + hotelIDFile.getPath());
        }
    }

    public static File getHotelFile() {
        return staticHotelFile;
    }

    public File getHotelIDFile() {
        return hotelIDFile;
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////
    public Hotel addHotel(Hotel hotel) throws InstanceAlreadyExistsException {
        if (findInHotelDB(hotel, staticHotelFile)) {
            throw new InstanceAlreadyExistsException("The hotel " + hotel.getName() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(staticHotelFile, true))) {
            bufferedWriter.append(setHotelID(hotelIDFile)).append(',');
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

    public long deleteHotel(long ID) {
        return deleteInstance(ID, staticHotelFile);
    }

    private Map<String, String> findHotelByParam(String param, int x) {
        if (staticHotelFile == null || (staticHotelFile.length() == 0)) {
            return new HashMap<>();
        }
        Map<String, String> hotelsByParam = new HashMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(staticHotelFile.getPath()))) {
            String nameTemp;
            while ((nameTemp = bufferedReader.readLine()) != null) {
                String[] hotelDescription = nameTemp.split(",");
                if (hotelDescription[x].equals(param)) {
                    hotelsByParam.put(hotelDescription[0], param);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + staticHotelFile + "no exist");
        } catch (IOException e) {
            System.out.println("Can't read file " + staticHotelFile);
        }
        return hotelsByParam;
    }

    private String setHotelID(File hotelIDfile) {
        String string = null;
        try {
            string = Long.toString(Long.parseLong(FileUtils.readFileToString(hotelIDfile)) + 1);
            FileUtils.writeStringToFile(hotelIDfile, string);
        } catch (IOException e) {
            System.out.println("Can not read from DBFile or write to DBFile " + hotelIDfile);
        }
        return string;
    }

    private boolean findInHotelDB(Hotel hotel, File hotelFile) {
        if (hotelFile.length() == 0) {
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









