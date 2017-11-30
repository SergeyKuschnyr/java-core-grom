package lesson34.transferSentences;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Kushn_000 on 26.11.2017.
 */
public class Solution {
    void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        handlingFiles(fileFromPath, fileToPath, word);
    }

    private void handlingFiles(String fileFromPath, String fileToPath, String word) {
        try {
            FileReader fileReader = new FileReader(fileFromPath);
            FileWriter fileWriter = new FileWriter(fileToPath, true);
            File file = new File(fileFromPath.substring(0, fileFromPath.lastIndexOf('/')) + "/" + "testtemp.txt");
            FileWriter fileWriter1 = new FileWriter(file);

            int ch;
            String string = "";

            while ((ch = fileReader.read()) != -1) {
                if ((char) ch != '.') {
                    string += ((char) ch);
                } else if (string.contains(word) && string.length() > 10) {
                    fileWriter.append(string + ".");
                    string = "";
                } else {
                    fileWriter1.append(string + ".");
                    string = "";
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Writing failure to file");
        } finally {
            try {
                fileWriter.close();
                fileReader.close();
                fileWriter1.close();
            }catch (Exception e){
                System.out.println("Error");
            }
        }

        Path fileToDeletePath = Paths.get(fileFromPath);
        Files.delete(fileToDeletePath);
        file.renameTo(new File(fileFromPath));
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFrom + " don't excist");
        }
        if (fileFrom.length() == 0) {
            throw new Exception("File " + fileFrom + " is empty");
        }
        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileTo + " don't excist");
        }
        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFrom + " does not have permission to be read");
        }
        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileTo + " does not have permission to be written");
        }
    }
}

