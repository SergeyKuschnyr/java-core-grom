package lesson33.readFromConsol;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Kushn_000 on 19.11.2017.
 */
public class WriteToFileFromConsole {
    void writeToFileFromConsole(String path) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        String content = "";

        System.out.println("Enter file content to write in the file:");

        try {
            String str;
            while (!(str = br.readLine()).equals("wr")) {
                content += str;
            }
        } catch (IOException e) {
            System.out.println("Reading from keyboard fault");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

        if (!doesFileExist(path)){
            return;
        }

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
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

//    private void doesFileExist(String path){
//        String path2 = path.substring(0, path.lastIndexOf('/'));
//        File file = new File(path2);
//        try {
//            if (!file.isDirectory()) {
//                throw new Exception("Can't write to file2 with path " + path);
//            }
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//            return;
//        }
//
//        File file2 = new File(path);
//        try {
//            if (!file2.exists()) {
//                throw new FileNotFoundException("File with path " + path + " not found");
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//    }
}
