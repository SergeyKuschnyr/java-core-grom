package lesson33.fileByConsole;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Kushn_000 on 20.11.2017.
 */
public class ReadFileByConsolePath {
    void readFileByConsolePath(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String content = "";

        System.out.println("Please, enter file path to read:");

        System.out.println("Enter file content to write in the file:");

        try {
            content = br.readLine();
        } catch (IOException e) {
            System.out.println("Reading from keyboard fault");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

        if (!doesFileExist(content)){
            return;
        }
    }

    private boolean doesFileExist(String path) {
        String path2 = path.substring(0, path.lastIndexOf('/'));
        File file = new File(path2);
        if (!file.isDirectory()) {
            System.out.println("Can't write to file2 with path " + path);
            return false;
        }

        File file2 = new File(path);
        if (!file2.exists()) {
            System.out.println("File with path " + path + " not found");
            return false;
        }
        return true;
    }
}
