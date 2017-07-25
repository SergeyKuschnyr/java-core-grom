package lesson18.exercise1.exercise4;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "qwerty asdfgh 123 cvbnm 23456 qwer567 1.1234   4567 34.56 56. .89 ...34";
        System.out.println(Arrays.toString(findNumbers(string)));
    }

    public static int[] findNumbers(String text) {
        String[] strings = text.split(" ");
        String[] tempString = {};
        int count = 0;
        for (String str : strings) {
            try {
                Integer.parseInt(str);
                count++;
            } catch (Exception e) {
                tempString = str.split("\\.");
                if (tempString.length == 2) {
                    try {
                        Integer.parseInt(tempString[0]);
                        Integer.parseInt(tempString[1]);
                        System.out.println("not a number");
                    } catch (Exception e1) {
                        System.out.println("error");
                    }
                }
            }
        }

        int[] intArray = new int[count];
        count = 0;
        for (String str : strings) {
            try {
                intArray[count] = Integer.parseInt(str);
                count++;
            } catch (Exception e) {
                System.out.println("error");
            }
        }
        return intArray;
    }
}
