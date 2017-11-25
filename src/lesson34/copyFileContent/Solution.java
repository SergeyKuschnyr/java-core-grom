package lesson34.copyFileContent;

import java.io.*;

/**
 * Created by Kushn_000 on 25.11.2017.
 */
public class Solution {
    public void copyFileContent(String fileFromPath, String fileToPath) throws Exception{
        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));
    }

    private StringBuffer readFromFile(String fileFromPath){
        StringBuffer res = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(fileFromPath))){
            String line;
            while((line = br.readLine()) != null){
                res.append(line);
                res.append("\n");
            }
            res.replace(res.length() - 1, res.length(), "");
        }catch (FileNotFoundException e){
            System.err.println("File does not exist");
        }catch (IOException e){
            System.err.println("Read from file"+ fileFromPath + "failed");
        }
        return res;
    }

    private void writeToFile(String fileToPath, StringBuffer res){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileToPath, true))){
            bufferedWriter.append(res);
        }catch (Exception e){
            System.err.println("Can't write to file");
        }
    }

    private void validate(String fileFromPath, String fileToPath) throws Exception{
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()){
            throw new FileNotFoundException ("File " + fileFrom + " don't excist");
        }
        if (!fileTo.exists()){
            throw new FileNotFoundException ("File " + fileTo + " don't excist");
        }
        if (!fileFrom.canRead()){
            throw new Exception ("File " + fileFrom + " does not have permission to be read");
        }
        if (!fileTo.canWrite()){
            throw new Exception ("File " + fileTo + " does not have permission to be written");
        }
    }
}
