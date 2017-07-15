package lesson17.hw2;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class hw2 {
    public static String maxWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] strings = input.split(" ");

        String maxString = "";

        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string)) {
                if (string.length() > maxString.length()) {
                    maxString = string;
                }
            }
        }

        if (maxString == "") {
            return null;
        }
        return maxString;
    }

    public static String minWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] strings = input.split(" ");

        String minString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string)) {
                if (string.length() < minString.length()) {
                    minString = string;
                }
            }
        }
        return minString;
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
}
