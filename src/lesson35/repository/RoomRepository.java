package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomRepository {
    private File roomFile;
    private File IDFile;
    HotelRepository hr = new HotelRepository();

    public void setRoomFile(File file) {
        this.roomFile = file;
    }

    public void setIDFile(File file) {
        this.IDFile = file;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(IDFile))) {
            bufferedWriter.append("100");
        } catch (IOException e) {
            System.out.println("Can't write to the file " + IDFile.getPath());
        }
    }

    public Map findRooms(Filter filter) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomFile))) {
            String string;
            Map<String, String> findRoom = new HashMap<>();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[1].equals(Integer.toString(filter.getNumberOfGuests())) &&
                        strings[2].equals(Double.toString(filter.getPrice())) &&
                        strings[3].equals(Boolean.toString(filter.isBreakfastIncluded())) &&
                        strings[4].equals(Boolean.toString(filter.isPetsAllowed())) &&
                        strings[5].equals((new SimpleDateFormat("DD-MM-YY")).format(filter.getDateAvailableFrom())) &&
                        strings[6].equals(findHotelByParam(filter.getCountry(), filter.getCity()))) {
                    findRoom.put("found room with ID", strings[0]);
                }
            }
        }
        return null;
    }

    public void addRoom(Room room) throws IOException {
        FileWriter fileWriter = new FileWriter(roomFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
    }

    public void deleteRoom(Room room) {    // Admin

    }

    private String findHotelByParam(String country, String city) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(hr.getHotelFile()))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[2].equals(country) && strings[3].equals(city)){
                    return strings[0];
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("File " + hr.getHotelFile().getPath() + "not found");
        }catch (IOException e){
            System.out.println("Can't read file " + hr.getHotelFile().getPath());
        }
        return null;
    }
}











