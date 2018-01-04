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
    private File roomDB;

    public void setRoomDB(File roomDB) {
        this.roomDB = roomDB;
    }

    public File getRoomDB() {
        return roomDB;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Map findRooms(Filter filter) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(HotelRepository.getHotelFile()))) {
            String string;
            Map findRoom = new HashMap();
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[2].equals(filter.getCountry()) && strings[3].equals(filter.getCity())) {
                    findRoomByHotel(strings[0], findRoom);
                }
            }
            return findRoom;
        } catch (FileNotFoundException e) {
            System.out.println("File " + "not found");
        } catch (IOException e) {
            System.out.println("Can't read file ");
        }
        return new HashMap();
    }

    public Room addRoom(Room room) throws Exception {
        if (UserRepository.getUser().getTYPE().equals(UserType.USER_TYPE)) {
            throw new Exception("You haven't the right for using this function");
        }
        if (findInRoomDB(room, roomDB)) {
            throw new InstanceAlreadyExistsException("The room " + room.toString() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomDB, true))) {
            bufferedWriter.append(setID()).append(',');
            bufferedWriter.append(Integer.toString(room.getNumberOfGuests())).append(',');
            bufferedWriter.append(Double.toString(room.getPrice())).append(',');
            bufferedWriter.append(Boolean.toString(room.isBreakfastIncluded())).append(',');
            bufferedWriter.append(Boolean.toString(room.isPetsAllowed())).append(',');
            bufferedWriter.append(room.getDateAvailableFrom().toString()).append(',');
            bufferedWriter.append(Long.toString(room.getHotel().getId())).append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File " + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to DBFile");
        }
        return room;
    }

    public long deleteRoom(long ID) throws Exception {
        if (UserRepository.getUser().getTYPE().equals(UserType.USER_TYPE)) {
            throw new Exception("You haven't the right for using this function");
        }
        return deleteInstance(ID, roomDB);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map findRoomByHotel(String ID, Map findRoom) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomDB))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                if (strings[6].equals(ID)) {
                    findRoom.put(strings[0], strings[6]);
                }
            }
            return findRoom;
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (IOException e) {

        }
        return new HashMap();
    }

    private boolean findInRoomDB(Room room, File roomFile) {
        if (roomFile == null || roomFile.length() == 0) {
            return false;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomFile))) {
            String roomString;
            while ((roomString = bufferedReader.readLine()) != null) {
                String[] roomArr = roomString.split(",");
                if (roomArr[1].equals(Integer.toString(room.getNumberOfGuests())) &&
                        roomArr[2].equals(Double.toString(room.getPrice())) &&
                        roomArr[3].equals(Boolean.toString(room.isBreakfastIncluded())) &&
                        roomArr[4].equals(Boolean.toString(room.isPetsAllowed())) &&
                        roomArr[5].equals((new SimpleDateFormat("dd-mm-yy")).format(room.getDateAvailableFrom())) &&
                        roomArr[6].equals(Long.toString(room.getHotel().getId()))) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("findInRoomDB error: Can't read file " + roomFile.getPath());
        }
        return false;
    }
}











