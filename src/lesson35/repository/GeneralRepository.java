package lesson35.repository;

import lesson35.model.Hotel;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.lang.reflect.Field;

/**
 * Created by Kushn_000 on 17.12.2017.
 */
public class GeneralRepository {

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
}







