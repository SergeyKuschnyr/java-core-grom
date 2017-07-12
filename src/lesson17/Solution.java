package lesson17;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 07.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the. source; code, oftyui123 the#, definition: for, editing " +
                "and close, the quick.   definition 567 lot <= ";
        String string2 = "";
        // String string3 = null;
        String wrongString = "!@#$% +_)(* *&^%$";

        System.out.println(countWords(string));
        System.out.println(maxWord(string));
        System.out.println(minWord(string));
        System.out.println(maxWord(wrongString));

        //       System.out.println(countWords(string2));
        //   System.out.println(maxWord(string2));
//        System.out.println(minWord(string2));

//        System.out.println(countWords(string3));
//        System.out.println(maxWord(string3));
//        System.out.println(minWord(string3));
    }

    public static int countWords(String input) {
        String[] strings = input.split(" ");
        if (strings.length == 0)
            return 0;
        int count = 0;
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                count++;
        }
        return count;
    }

    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }


    public static String maxWord(String input) {
        String[] strings = input.split(" ");
        if (strings.length == 0)
            return null;
        String maxString = "";
        //если во входящих данных нет вообще слов подходящих, что будет?
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                if (string.length() > maxString.length())
                    maxString = string;
        }
        if (maxString == "")
            return null;
        return maxString;
    }

    public static String minWord(String input) {
        String[] strings = input.split(" ");
        if (strings.length == 0)
            return null;
        String minString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                if (string.length() < minString.length())
                    minString = string;
        }
        return minString;
    }

    public static String mostCountedWord(String input) {

        return null;
    }
}