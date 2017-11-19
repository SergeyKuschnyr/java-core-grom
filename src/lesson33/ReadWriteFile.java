package lesson33;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Kushn_000 on 19.11.2017.
 */
public class ReadWriteFile {
    public static void main(String[] args) {
        //readFile("c:/Users/Kushn_000/Desktop/service_routing.txt");

        writerFile("c:/Users/Kushn_000/Desktop/test.txt", "TTTTTTTTT");
    }

    public static void readFile(String path) {
        FileReader reader;
        try {
            reader = new FileReader(path);
        }catch (FileNotFoundException e){
            System.err.println("File dos not exist");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.err.println("Reading from line " + path + "failed");
        }
        finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }

    public static void writerFile(String path, String content){
        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        }catch (IOException e){
            System.err.println("Can't write to file");
        }
        finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }
}
