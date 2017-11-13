package lesson32.readingNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Kushn_000 on 06.11.2017.
 */
public class Solution {
    public void readNumbers() throws IOException {
        ArrayList<Integer> intAL = new ArrayList<>();

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Input 10 numbers: ");
            String[] strings = br.readLine().split(" ");

            for (String str : strings) {
                if (!str.isEmpty() && !hasNumberAtWord(str)) {
                    intAL.add(Integer.parseInt(str));
                }
            }

            if (!validator(intAL)) {
                if (i == 2){
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    break;
                }
                System.out.println("Your numbers are wrong. You have " + (2 - i) + " attempts to try again");
            } else {
                int sum = 0;
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

    private boolean validator(ArrayList<Integer> intAL) {
        if (intAL.size() != 10)
            return false;
        for (Integer integer : intAL) {
            if (integer > 100) {
                return false;
            }
        }
        return true;
    }

    private boolean hasNumberAtWord(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}