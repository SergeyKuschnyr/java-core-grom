package lesson35.repository;

import lesson35.model.Hotel;
import lesson35.model.Room;
import lesson35.model.User;
import lesson35.model.UserType;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Kushn_000 on 17.12.2017.
 */
public class GeneralRepository {
    private Set<Long> IDCollection = new HashSet<>();

    public long fileUpdate(long ID, File DBFile) {
        if (ID == 0 || DBFile == null || DBFile.length() == 0) {
            return 0;
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBFile, true))) {
            String instanceInfo;
            StringBuilder newContent = new StringBuilder("");
            int count = 0;

            while ((instanceInfo = bufferedReader.readLine()) != null) {
                String[] instanceArr = instanceInfo.split(",");
                if (instanceArr[0].equals(Long.toString(ID))) {
                    count++;
                    continue;
                }
                newContent.append(instanceInfo).append("\n");
            }
            if (count != 0) {
                FileUtils.write(new File(DBFile.getPath()), "");
                bufferedWriter.append(newContent.toString());
                return ID;
            }
        } catch (IOException e) {
            System.out.println("Can't read DBFile " + DBFile.getPath());
        }
        return 0;
    }

    public String setID() {
        while (true) {
            long value = Long.valueOf(new Random().nextInt(1000));
            if (IDCollection.add(value)) {
                return Long.toString(value);
            }
        }
    }

    public ArrayList instanceDB(File file) {
        if (file == null || file.length() == 0) {
            return new ArrayList();
        }
        ArrayList instancesAL = new ArrayList();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string = "";
            while ((string = bufferedReader.readLine()) != null) {
                String[] strings = string.split(",");
                User user = new User(strings[1], strings[2], strings[3], UserType.valueOf(strings[4]));//////////
                user.setId(Long.parseLong(strings[0]));///////////////////////////////////////////////////////////
                instancesAL.add(user);
            }
        } catch (IOException e) {
            System.out.println("Can't read from file:" + file.getPath());
        }
        return instancesAL;
    }

//    public <T> ArrayList instanceDB(File file, T t) throws ParseException {
//        if (file == null || file.length() == 0) {
//            return new ArrayList();
//        }
//        ArrayList generalAL = new ArrayList();
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
//            String string = "";
//            while ((string = bufferedReader.readLine()) != null) {
//                String[] strings = string.split(",");
//                if (t instanceof User) {
//                    User user = new User(strings[1], strings[2], strings[3], UserType.valueOf(strings[4]));//////////
//                    user.setId(Long.parseLong(strings[0]));///////////////////////////////////////////////////////////
//                    t = (T) user;
//                } else if (t instanceof Hotel) {
//                    Hotel hotel = new Hotel(strings[1], strings[2], strings[4], strings[4]);
//                    hotel.setId(Long.parseLong(strings[0]));
//                    t = (T) hotel;
//                } else if (t instanceof Room) {
//                    Room room = new Room(Integer.parseInt(strings[1]), Double.parseDouble(strings[2]),
//                            Boolean.parseBoolean(strings[3]), Boolean.parseBoolean(strings[4]),
//                            (new SimpleDateFormat("dd-MMM-yyyy")).parse(strings[5]),
//                            new Hotel(null, null, null, null));
//                    room.setId(Long.parseLong(strings[0]));
//                    t = (T) room;
//                }
//                generalAL.add(t);
//            }
//        } catch (IOException e) {
//            System.out.println("Can't read from file:" + file.getPath());
//        }
//        return generalAL;
//    }

}







