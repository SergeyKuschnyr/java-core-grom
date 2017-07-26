package lesson18.exercise1.exercise4;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "qwerty asdfgh 123 cvbnm 23456 qwer567 1.1234  4567 34.56 56. .89 ...34";
        System.out.println(Arrays.toString(findNumbers(string)));
    }

    public static int[] findNumbers(String text) {

        String[] strings = text.split(" ");
        int count = 0;
        for (String str : strings) {
            char[] chars = str.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    count++;
                    break;
                }
            }
        }

        count = strings.length - count - 1;
        int[] intArray = new int[count];
        count = 0;
        boolean flag = false;

        for (String str : strings) {
            char[] chars = str.toCharArray();
            if (chars.length == 0)
                continue;
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    flag = true;
                    break;
                }
            }
            if (flag){
                flag = false;
                continue;
            }
            intArray[count] = Integer.parseInt(str);
            count++;
        }
        return intArray;
    }
}


