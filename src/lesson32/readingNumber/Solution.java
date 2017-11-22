package lesson32.readingNumber;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Kushn_000 on 06.11.2017.
 */
public class Solution {
    public void readNumbers() throws IOException {
        int attemptCount = 3;

        while (attemptCount != 0) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String string = br.readLine();
            String[] items = string.split(" ");

            if (!validator(items)) {
                if (attemptCount == 1) {
                    System.out.println("Your numbers are wrong. Number of attempts exceeded");
                    return;
                }
                System.out.println("Your numbers are wrong. You have " +
                        --attemptCount + " attempts to try again");
                continue;
            }

            int res = 0;
            for (String str : items){
                res += Integer.parseInt(str);
            }
            System.out.println(res);
            return;
        }
    }

    private boolean validator(String[] strings) {
        if (strings.length != 10) {
            return false;
        }

        for (String string : strings) {
            for (char ch : string.toCharArray()) {
                if (Character.isLetter(ch))
                    return false;
            }
            if (Integer.parseInt(string) > 100)
                return false;
        }
        return true;
    }

}
