package lesson17.hw3;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff";

        String string2 = "раз два два три три три три три пять пять пять пять пять " +
                "восемь восемь восемь восемь восемь восемь восемь 1111111111111111";
        String string3 = "qwerty";
        String string4 = "раз два три пять восемь 1111111111111111";

//        String wrongString = "!@#$% +_)(* *&^%$";
//        String internetAddress = "http://gromcode.com";

        System.out.println("\"6789 asdfgh\"");
        System.out.println(mostCountedWord("6789 asdfgh"));
        System.out.println("\"asdfgh 6789\"");
        System.out.println(mostCountedWord("asdfgh 6789"));
        System.out.println("\"Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff\"");
        System.out.println(mostCountedWord(string));
        System.out.println("\"раз два два три три три три три пять пять пять пять пять " +
                "восемь восемь восемь восемь восемь восемь восемь 1111111111111111\"");
        System.out.println(mostCountedWord(string2));
        System.out.println("\"qwerty\"");
        System.out.println(mostCountedWord(string3));
        System.out.println("\"раз два три пять восемь 1111111111111111\"");
        System.out.println(mostCountedWord(string4));
    }

    public static String mostCountedWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] strings = input.split(" ");
        if (strings.length == 1) {
            if (checkLetter(strings[0])) {
                return strings[0];
            }
            return null;
        }

        int count = 0;
        int count2 = 0;
        String tempString = "";

        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; i != j && j < strings.length; j++) {
                if (checkLetter(strings[i]) && strings[i].equals(strings[j])) {
                    count++;
                }
            }
            if (count > count2) {
                count2 = count;
                tempString = strings[i];
            }
            count = 0;
        }

        if (tempString == "") {
            return null;
        }
        return tempString;
    }

    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

//    public static boolean qwerty(String str1, String str2) {
//        if (str1.length() != str2.length())
//            return false;
//        char[] ch1 = str1.toCharArray();
//        char[] ch2 = str2.toCharArray();
//        for (int i = 0; i < ch1.length; i++) {
//                if (ch1[i] != ch2[i]) {
//                    return false;
//                }
//            }
//        return true;
//    }
}
