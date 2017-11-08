package lesson32.readingNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kushn_000 on 06.11.2017.
 */
public class Solution {
    public void readNumbers() throws IOException {
        ArrayList<Integer> intAL = new ArrayList();
        int sum = 0;

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Input 10 numbers: ");

            String[] strings = br.readLine().split(" ");
            if (strings.length != 10) {
                System.out.println("Your numbers are wrong. You have " + (2 - i) + " attempts to try again");
                counter++;
                continue;
            }
            for (String str : strings) {
                intAL.add(Integer.parseInt(str));
            }

            if (!numberValidate(intAL)) {
                System.out.println("Your numbers are wrong. You have " + (2 - i) + " attempts to try again");
            } else {
                for (Integer integer : intAL) {
                    sum += integer;
                }
                System.out.println("Sum: " + sum);
                break;
            }
            intAL.clear();
            counter++;
        }
        if (counter == 3)
            System.out.println("Your numbers are wrong. Number of attempts exceeded");
    }

    private boolean numberValidate(ArrayList<Integer> intAL) {
        for (Integer integer : intAL) {
            if (integer > 100) {
                return false;
            }
        }
        return true;
    }
}