package lesson35.repository;

import lesson35.model.Hotel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Kushn_000 on 17.12.2017.
 */
public class GeneralRepository {
    private Set<Long> IDCollection = new HashSet<>();

    public long deleteInstance(long ID, File DBFile) {
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
}







