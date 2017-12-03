package lesson34.copyingUsingDifferentLib;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.File;

/**
 * Created by Kushn_000 on 30.11.2017.
 */
public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) {
        try (   BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileFromPath)));
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(new File(fileToPath)))) {

            validate(fileFromPath, fileToPath);

            StringBuffer stringBuffer = new StringBuffer();
            String string = "";
            while ((string = fileReader.readLine()) != null) {
                stringBuffer.append(string + "\n");
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            fileWriter.append(stringBuffer.substring(0));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws IOException{
        File file1 = new File(fileFromPath);
        File file2 = new File(fileToPath);
        FileUtils.writeStringToFile(file2,FileUtils.readFileToString(file1));
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
