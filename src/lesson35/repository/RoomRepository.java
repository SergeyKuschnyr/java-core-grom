package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Room;
import org.apache.commons.io.FileUtils;

import javax.management.InstanceAlreadyExistsException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 10.12.2017.
 */
public class RoomRepository extends GeneralRepository {
    private File roomFile;
    private File roomIDFile;
    //private HotelRepository hotelRepository = new HotelRepository();

    public void setRoomFile(File roomFile) {
        this.roomFile = roomFile;
    }

    public void setRoomIDFile(File file) {
        this.roomIDFile = file;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomIDFile))) {
            bufferedWriter.append("100");
        } catch (IOException e) {
            System.out.println("Can't write to the file " + roomIDFile.getPath());
        }
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
            System.out.println("File " +  "not found");
        } catch (IOException e) {
            System.out.println("Can't read file " );
        }
        return new HashMap();
    }

    public Room addRoom(Room room) throws InstanceAlreadyExistsException {
        if (findInRoomDB(room, roomFile)) {
            throw new InstanceAlreadyExistsException("The room " + room.toString() + " already exist");
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(roomFile, true))) {
            bufferedWriter.append(setRoomID(roomIDFile)).append(',');
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

    public long deleteRoom(long ID) {    // Admin
        return deleteInstance(ID, roomFile);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    private Map findRoomByHotel(String ID, Map findRoom) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(roomFile))) {
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

    private String setRoomID(File IDfile) {
        String string = null;
        try {
            string = Long.toString(Long.parseLong(FileUtils.readFileToString(IDfile)) + 1);
            FileUtils.writeStringToFile(IDfile, string);
        } catch (IOException e) {
            System.out.println("Can not read from DBFile or write to DBFile " + IDfile);
        }
        return string;
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











