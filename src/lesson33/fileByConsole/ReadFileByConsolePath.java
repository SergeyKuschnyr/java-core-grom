package lesson33.fileByConsole;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Kushn_000 on 20.11.2017.
 */
public class ReadFileByConsolePath {
    void readFileByConsolePath(){
        String path = "";

        System.out.println("Please, enter file path to read:");

        path = readPathFromConsole();

        writeFileContent(path);
    }

    private String readPathFromConsole(){
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String path = "";
        try {
            path = br.readLine();
        } catch (IOException e) {
            System.out.println("Reading from keyboard fault");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
        return path;
    }

    private void writeFileContent(String path){
        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader brFromFile = new BufferedReader(fileReader);

        try {
            String line;
            while ((line = brFromFile.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println("Can't read file by path: " + path);
        }
        finally {
            IOUtils.closeQuietly(brFromFile);
            IOUtils.closeQuietly(fileReader);
        }
    }
}
