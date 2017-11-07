package lesson32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Kushn_000 on 06.11.2017.
 */
public class ReadFromKeyboard {
    public static void main(String[] args) throws IOException{
        //readKeyboardWithScanner();
        System.out.println();
        readKeyboardWithIOStream();
    }

    private static void readKeyboardWithScanner() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your name:");

        String[] strings = scanner.nextLine().split(" ");
        stringValidate(strings);
        scanner.close();
    }

    private static void readKeyboardWithIOStream() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please enter your name:");

        String[] strings = br.readLine().split(" ");
        stringValidate(strings);
    }

    private static boolean wordValidate(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch)) {
                return false;
            }
        }
        return true;
    }

    private static void stringValidate(String[] strings){
        if (strings.length > 1) {
            System.out.println("Wrong Name");
        } else if (wordValidate(strings[0])) {
            System.out.println("Hello, " + strings[0]);
        } else {
            System.out.println("Wrong Name");
        }
    }
}
