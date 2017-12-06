package lesson34.transferSentences;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.io.File;

/**
 * Created by Kushn_000 on 26.11.2017.
 */
public class Solution {
    void transferSentences(String fileFromPath, String fileToPath, String word) {
        try {
            validate(fileFromPath, fileToPath);
            String fileContent = readFromFile(fileFromPath).toString();
            String[] sentences = fileContent.split(".");
            FileUtils.copyFile(new File(""), new File(""));
            StringBuilder sentencesWithWord = new StringBuilder();
            for (String sentence : sentences) {
                if (sentence.contains(word) && sentence.length() > 10) {
                    sentencesWithWord.append(sentence).append(".");
                    fileContent = fileContent.replace(sentencesWithWord + ".", "");
                }
            }
            writeToFiles(fileFromPath, fileContent);
            writeToFiles(fileToPath, sentencesWithWord);
        } catch (Exception e) {
            System.out.println("Write to file failure");
        }
    }
    private StringBuffer readFromFile(String path) throws IOException {
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        } catch (IOException e) {
            throw new IOException("Reading from line " + path + "failure", e);
        }
        return res;
    }

    private <T extends CharSequence> void writeToFiles(String path, T contentToWrite) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            throw new IOException("Can't write to file" + path, e);
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