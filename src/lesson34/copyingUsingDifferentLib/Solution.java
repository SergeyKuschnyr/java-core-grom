package lesson34.copyingUsingDifferentLib;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Kushn_000 on 30.11.2017.
 */
public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) {
        try (FileWriter fileWriter = new FileWriter(new File(fileToPath))){
            validate(fileFromPath, fileToPath);
            for (String string : Files.readAllLines(Paths.get(fileFromPath))){
            fileWriter.append(string);
        }
        }catch (Exception e){
            System.out.println("Write to file failure");
        }
    }

    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) {
        File file1 = new File(fileFromPath);
        File file2 = new File(fileToPath);
        try {
            validate(fileFromPath, fileToPath);
            FileUtils.writeStringToFile(file2, FileUtils.readFileToString(file1));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
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
