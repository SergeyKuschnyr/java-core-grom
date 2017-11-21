package lesson33.readFromConsol;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * Created by Kushn_000 on 19.11.2017.
 */
public class WriteToFileFromConsole {
    void writeToFileFromConsole(String path) {
        String content = "";

        if (!doesFileExist(path)) {
            return;
        }

        System.out.println("Enter file content to write in the file:");

        content = readFromKeyboard();

        writeToFile(path, content);
    }

    private boolean doesFileExist(String path) {
        File file2 = new File(path);
        if (!file2.exists()) {
            System.out.println("File with path " + path + " not found");
            return false;
        }
        return true;
    }

    private String readFromKeyboard() {
        String content = "";
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

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
        return content;
    }

    private void writeToFile(String path, String content) {
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
}
