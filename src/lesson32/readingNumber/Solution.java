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

            createArrayList(strings, intAL);

            if (!validator(intAL)) {
                System.out.println("Your numbers are wrong. You have " + (2 - i) + " attempts to try again");
            } else {
                sumCounting(intAL);
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

    private void sumCounting(ArrayList<Integer> intAL) {
        int sum = 0;
        for (Integer integer : intAL) {
            sum += integer;
        }
        System.out.println("Sum: " + sum);
    }

    private void createArrayList(String[] strings, ArrayList intAL){
        for (String str : strings) {
            if (!str.isEmpty())
                intAL.add( Integer.parseInt(str));
        }
    }
}