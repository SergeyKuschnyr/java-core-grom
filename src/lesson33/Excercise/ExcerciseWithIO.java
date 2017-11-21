package lesson33.Excercise;

import java.io.*;

/**
 * Created by Kushn_000 on 21.11.2017.
 */
public class ExcerciseWithIO {

    public static void main(String[] args) throws IOException{
        first();
    }

    static void first() throws IOException{

        // reading from keyboard
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println(bufferedReader.readLine());

        // reading from file
        FileReader fileReader = new FileReader("path");
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        System.out.println(bufferedReader.readLine());

        System.out.println("Input something ");
    }
}
