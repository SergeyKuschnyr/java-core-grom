package lesson17;

/**
 * Created by Kushn_000 on 07.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the. source; code, oftyui123 the#, definition: for, editing " +
                "and close, the quick.   definition 567 lot <= ";
        String string2 = "";
        String string3 = null;
        System.out.println(countWords(string));
        System.out.println(maxWord(string));
        System.out.println(minWord(string));

        System.out.println(countWords(string2));
        System.out.println(maxWord(string2));
        System.out.println(minWord(string2));

        System.out.println(countWords(string3));
        System.out.println(maxWord(string3));
        System.out.println(minWord(string3));
    }

    public static int countWords(String input) {
        if (stringLetterArray(input) != null)
            return stringLetterArray(input).length;
        return 0;
    }

    public static String maxWord(String input) {
        if (stringLetterArray(input) != null) {
            String[] strings = stringLetterArray(input);
            int stringLength = 0;
            String outputString = "";
            for (String string : strings) {
                char[] chars = string.toCharArray();
                if (stringLength < chars.length) {
                    stringLength = chars.length;
                    outputString = string;
                }
            }
            return outputString;
        }
        return null;
    }

    public static String minWord(String input) {
        if (stringLetterArray(input) != null) {
            String[] strings = stringLetterArray(input);
            int stringLength = 100;
            String outputString = "";
            for (String string : strings) {
                char[] chars = string.toCharArray();
                if (stringLength > chars.length) {
                    stringLength = chars.length;
                    outputString = string;
                }
            }
            return outputString;
        }
        return null;
    }

    public static String[] stringLetterArray(String input) {
        if (input != null && input.length() != 0) {
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++)
                if (!Character.isLetter(chars[i]))
                    chars[i] = ' ';
            String outputString = new String(chars);
            String[] stringArr = outputString.split("\\s+");
            return stringArr;
        }
        return null;
    }

    public static String mostCountedWord(String input) {

        return null;
    }
}
