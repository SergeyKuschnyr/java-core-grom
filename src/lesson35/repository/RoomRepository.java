package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.UserType;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.io.File;
import java.text.ParseException;
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
    public Map findRooms(Filter filter) throws Exception {
        if (filter == null) {
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
            room.setId(Long.parseLong(setID()));
            bufferedWriter.append(Long.toString(room.getId()) + "," + Integer.toString(room.getNumberOfGuests()) + "," +
                    Double.toString(room.getPrice()) + "," + Boolean.toString(room.isBreakfastIncluded()) + "," +
                    Boolean.toString(room.isPetsAllowed()) + "," + room.getDateAvailableFrom().toString() + "," +
                    Long.toString(room.getHotel().getId())).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File of DB " + roomDB.getPath() + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to file " + roomDB.getPath());
        }
        return room;
    }

    public long deleteRoom(long ID) throws Exception {
        if (userTypeValidate().equals(UserType.USER_TYPE.toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        Map <String, Room> roomMap = mapping(readingOfDB(roomDB));
        for (Room room : roomMap.values()){
            if (room.getId() == ID){
                roomMap.remove(room.getId());
                return ID;
            }
        }
        throw new Exception("Entered ID " + ID + " not exist");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    private Map<String, Room> mapping(StringBuilder stringBuilder) {
        Map<String, Room> instanceDB = new HashMap();
        String s = stringBuilder.toString();
        String[] strings = s.split("\\n");
        for (String str : strings) {
            String[] strg = str.split(",");
            Room t = new Room(Integer.parseInt(strg[1]), Double.parseDouble(strg[2]), Boolean.parseBoolean(strg[3]),
                    Boolean.parseBoolean(strg[4]), getDateForRoom(strg[5]), getHotelForRoom(strg[6]));
            t.setId(Long.parseLong(strg[0]));
            instanceDB.put(strg[0], t);
        }
        return instanceDB;
    }

    private Date getDateForRoom(String s){
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
            return simpleDateFormat.parse(s);
        }catch (ParseException e){
            System.out.println("String to date casting error");
        }
        return null;
    }

    private Hotel getHotelForRoom(String s){
        Hotel hotel;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HotelRepository.getHotelDB()))) {
            String s1;
            while ((s1 = bufferedReader.readLine()) != null){
                String[] strings1 = s1.split(",");
                if (strings1[0].equals(s)){
                    hotel = new Hotel(strings1[1], strings1[2], strings1[3], strings1[4]);
                    hotel.setId(Long.parseLong(strings1[0]));
                    return hotel;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Can't find file: " + roomDB);
        }catch (IOException e) {
            System.out.println("Can't read file: " + roomDB);
        }
        return null;
    }

    private Map findRoomByHotel(String ID) throws Exception {
        if (ID == null) {
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

    private boolean roomValidate(Room room, File roomDB) throws Exception {
        if (userTypeValidate().equals(UserType.USER_TYPE.toString())) {
            throw new Exception("You haven't the right for using this function");
        }
        if (roomDB == null) {
            throw new Exception("The file of DB " + roomDB.getPath() + " not found");
        }
        if (roomDB.length() == 0) {
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

    public String userTypeValidate() throws Exception {
        File file = new File((new UserRepository()).getPath().toString());
        if (file == null || file.length() == 0) {
            throw new Exception("ERROR: The DB not found or one is empty");
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                if (string.split(",").length == 6) {
                    return string.split(",")[4];
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: Can't read from file" + file.getPath());
        }
        return null;
    }
}











