package lesson35.repository;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by Kushn_000 on 17.12.2017.
 */
public class GeneralRepository {

    public <T> T add(T t, File DBFile, File IDFile) {
        if (findInstanceInDB(t, DBFile) != null) {
            return null;
        }
        System.out.println("TEST");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBFile, true))) {
            Field[] fields = t.getClass().getDeclaredFields();
            bufferedWriter.append(setHotelID(IDFile)).append(',');
            for (int i = 0; i < fields.length; i++) {
                bufferedWriter.append(fields[i].getName()).append(',');
            }
            bufferedWriter.append("\n");
        } catch (FileNotFoundException e) {
            System.out.println("File " + " not found");
        } catch (IOException e) {
            System.out.println("Can't write to DBFile");
        }
        return t;
    }

    public long delete(long ID, File DBFile) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(DBFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(DBFile))) {
            String hotelInfo;
            StringBuffer stringBuffer = new StringBuffer("");
            int count = 0;

            while ((hotelInfo = bufferedReader.readLine()) != null) {
                String[] hotelArr = hotelInfo.split(",");
                if (hotelArr[0].equals(ID)) {
                    count++;
                    continue;
                }
                stringBuffer.append(hotelInfo).append("\\n");
            }
            if (count != 0) {
                bufferedWriter.write(stringBuffer.toString());
                return ID;
            }
        } catch (IOException e) {
            System.out.println("Can't read DBFile " + DBFile.getPath());
        }
        return 0;
    }

    private String setHotelID(File IDfile) {
        String string = null;
        try {
            string = Long.toString(Long.parseLong(FileUtils.readFileToString(IDfile)) + 1);
            FileUtils.writeStringToFile(IDfile, string);
        } catch (IOException e) {
            System.out.println("Can not read from DBFile or write to DBFile " + IDfile);
        }
        return string;
    }

    private <T> T findInstanceInDB(T t, File instanceFile) {
        if (instanceFile.length() == 0) {
            return null;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(instanceFile))) {
            String instanceString;
            while ((instanceString = bufferedReader.readLine()) != null) {
                if (instanceCompare(t, instanceString)){
                    return t;
                }
            }
        } catch (IOException e) {
            System.out.println("findInstanceInDB error: Can't read file " + instanceFile.getPath());
        }
        return null;
    }

    private <T> boolean instanceCompare(T t, String instanceString) {
        Field[] fields = t.getClass().getDeclaredFields();
        String[] hotelArr = instanceString.split(",");
        for (int i = 0; i < hotelArr.length -1; i++) {
            if (hotelArr[i].equals(fields[i].toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "GeneralRepository{}";
    }
}







