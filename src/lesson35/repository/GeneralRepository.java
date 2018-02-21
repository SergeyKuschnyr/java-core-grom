package lesson35.repository;

import lesson35.model.Hotel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.util.*;

/**
 * Created by Kushn_000 on 17.12.2017.
 */
public class GeneralRepository {
    private Set<Long> IDCollection = new HashSet<>();

    public ArrayList<String> readFile(File DBfile) throws Exception {
        if (DBfile == null) {
            throw new Exception("GeneralRepository/readFile: input parameter is null");
        }
        if (DBfile.length() == 0) {
            throw new Exception("GeneralRepository/readFile: file " + DBfile.getPath() + "is empty");
        }

        ArrayList<String> stringAL = new ArrayList();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBfile))) {
            String string;
            while ((string = bufferedReader.readLine()) != null) {
                stringAL.add(string);
            }
        }
        return stringAL;
    }

//    public long deleteHotelFromDB(long ID, File DBFile) {
//        if (ID == 0 || DBFile == null || DBFile.length() == 0) {
//            return 0;
//        }
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBFile));
//             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBFile, true))) {
//            int counter = 0;
//            StringBuilder stringBuilder = readingOfDB(bufferedReader, ID, counter);
//            if (counter != 0) {
//                FileUtils.write(new File(DBFile.getPath()), "");
//                bufferedWriter.append(stringBuilder.toString());
//                return ID;
//            }
//        } catch (IOException e) {
//            System.out.println("Can't read DBFile " + DBFile.getPath());
//        }
//        return 0;
//    }

    public StringBuilder readingOfDB(File DBFile) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBFile))){
            String tempString = "";
            while ((tempString = bufferedReader.readLine()) != null){
                stringBuilder.append(tempString).append("\n");
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return stringBuilder;
    }

    private boolean findingOfHotel(String instanceInfo, long ID) {
        String[] instanceArr = instanceInfo.split(",");
        if (instanceArr[0].equals(Long.toString(ID))) {
            return true;
        }
        return false;
    }

    public String setID() {
        while (true) {
            long value = Long.valueOf(new Random().nextInt(1000));
            if (IDCollection.add(value)) {
                return Long.toString(value);
            }
        }
    }

//    public <T> ArrayList mapping(File file, T t) throws ParseException {
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







