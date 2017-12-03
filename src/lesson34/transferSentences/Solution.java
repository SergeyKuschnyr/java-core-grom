package lesson34.transferSentences;

import java.io.*;
import java.io.File;
import java.nio.file.Files;
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
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        FileWriter fileWriter1 = null;
        File file = null;
        try {
            fileReader = new FileReader(fileFromPath);
            fileWriter = new FileWriter(fileToPath, true);
            file = new File(fileFromPath.substring(0, fileFromPath.lastIndexOf('/')) + "/" +
                    "testtemp.txt");
            fileWriter1 = new FileWriter(file, true);

            writingToFiles(fileReader, word, fileWriter, fileWriter1);

        } catch (FileNotFoundException e) {
            System.out.println("File: " + fileFromPath + "not found");
        } catch (IOException e) {
            System.out.println("Can't write to file: " + fileToPath);
        } finally {
            try {
                fileReader.close();
                fileWriter.close();
                fileWriter1.close();
            } catch (IOException e) {
                System.out.println("Can't close stream");
            }
        }

        try {
            Files.delete(Paths.get(fileFromPath));
        } catch (IOException e) {
            System.out.println("Can't delete file: " + fileFromPath);
        }
        file.renameTo(new File(fileFromPath));
    }

    private void writingToFiles(FileReader fileReader, String word, FileWriter fileWriter,
                                FileWriter fileWriter1) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String string = "";
        String stringCollector = "";
        while ((string = bufferedReader.readLine()) != null) {
            stringCollector += string;
            stringCollector += "\n";
        }
        stringCollector = stringCollector.substring(0,stringCollector.length() - 1);

        for (String string1 : stringCollector.split("\\.")) {
            if (string1.contains(word) && string1.length() > 10) {
                fileWriter.append(string1 + ".");
            } else {
                fileWriter1.append(string1 + ".");
            }
        }

//        int ch = 0;
//        String string = "";
//        while ((ch = fileReader.read()) != -1) {
//            if ((char) ch != '.') {
//                string += ((char) ch);
//            } else if (string.contains(word) && string.length() > 10) {
//                fileWriter.append(string + ".");
//                string = "";
//            } else {
//                fileWriter1.append(string + ".");
//                string = "";
//            }
//        }
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

