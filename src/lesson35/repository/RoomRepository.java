package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;
import lesson35.model.UserType;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomRepository extends GeneralRepository {
    private static File roomDB;

    public void setRoomDB(File roomDB) {
        this.roomDB = roomDB;
    }

    public static File getRoomDB() {
        return roomDB;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Map findRooms(Filter filter) throws Exception{
        if (filter == null){
            System.out.println("Input date is error");
            return new HashMap();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HotelRepository.getHotelDB()))) {
            String string;
            Map foundRoom = new HashMap();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[2].equals(filter.getCountry()) && strings[3].equals(filter.getCity())) {
                    foundRoom.putAll(findRoomByHotel(strings[0]));
                }
            }
            return foundRoom;
        } catch (FileNotFoundException e) {
            System.out.println("File " + HotelRepository.getHotelDB().getPath() + "not found");
        } catch (IOException e) {
            System.out.println("Can't read file " + HotelRepository.getHotelDB().getPath());
        }
        return new HashMap();
    }

    public Room addRoom(Room room) throws Exception {
        if (roomValidate(room, roomDB)) {
            throw new InstanceAlreadyExistsException("The room " + room.toString() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomDB, true))) {
            String string = setID();
            room.setId(Long.parseLong(string));
            bufferedWriter.append(string).append(',');
            bufferedWriter.append(Integer.toString(room.getNumberOfGuests())).append(',');
            bufferedWriter.append(Double.toString(room.getPrice())).append(',');
            bufferedWriter.append(Boolean.toString(room.isBreakfastIncluded())).append(',');
            bufferedWriter.append(Boolean.toString(room.isPetsAllowed())).append(',');
            bufferedWriter.append(room.getDateAvailableFrom().toString()).append(',');
            bufferedWriter.append(Long.toString(room.getHotel().getId())).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File of DB " + roomDB.getPath() + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to file " + roomDB.getPath());
        }
        return room;
    }

    public long deleteRoom(long ID) throws Exception {
        if (userTypeValidate().equals(UserType.USER_TYPE.toString())){
            throw new Exception("You haven't the right for using this function");
        }
        return fileUpdate(ID, roomDB);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map findRoomByHotel(String ID) throws Exception{
        if (ID == null){
            throw new Exception("ERROR: Input date is error");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomDB))) {
            String string;
            Map findRoom = new HashMap();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                System.out.println("strings[0]: " + strings[0] + "     ID: " + ID);
                if (strings[0].equals(ID)) {
                    System.out.println("TESTTTT");

                    findRoom.put(strings[0], strings[6]);
                }
            }
            return findRoom;
        } catch (FileNotFoundException e) {
            System.out.println("File " + roomDB.getPath() + " not found");
        } catch (IOException e) {
            System.out.println("Can't read from file " + roomDB.getPath());
        }
        return new HashMap();
    }

    private boolean roomValidate(Room room, File roomDB) throws Exception{
        if (userTypeValidate().equals(UserType.USER_TYPE.toString() )){
            throw new Exception("You haven't the right for using this function");
        }
        if (roomDB == null) {
            throw  new Exception("The file of DB " + roomDB.getPath() + " not found");
        }
        if (roomDB.length() == 0){
            return false;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomDB))) {
            String roomString;
            while ((roomString = bufferedReader.readLine()) != null) {
                String[] roomArr = roomString.split(",");
                if (roomArr[1].equals(Integer.toString(room.getNumberOfGuests())) &&
                        roomArr[2].equals(Double.toString(room.getPrice())) &&
                        roomArr[3].equals(Boolean.toString(room.isBreakfastIncluded())) &&
                        roomArr[4].equals(Boolean.toString(room.isPetsAllowed())) &&
                        roomArr[5].equals((new SimpleDateFormat("dd-mm-yy")).
                                format(room.getDateAvailableFrom())) &&
                        roomArr[6].equals(Long.toString(room.getHotel().getId()))) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("roomValidate error: Can't read file " + roomDB.getPath());
        }
        return false;
    }

    public String userTypeValidate() throws Exception{
        if (UserRepository.getUserDB() == null || UserRepository.getUserDB().length() == 0){
            throw new Exception("ERROR: The DB not found or one is empty");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(UserRepository.getUserDB()))){
            String string = "";
            while ((string = bufferedReader.readLine()) != null){
                if (string.split(",").length == 6){
                    return string.split(",")[4];
                }
            }
        }catch (IOException e){
            System.out.println("ERROR: Can't read from file" + UserRepository.getUserDB().getPath());
        }
        return null;
    }
}











