package lesson17;

/**
 * Created by Kushn_000 on 07.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the. source; code, oftyui123 the, definition: for, editing " +
                "and close, the quick.   definition 567 lot";
        System.out.println(countWords(string));
        System.out.println(maxWord(string));
        System.out.println(minWord(string));

    }

    public static int countWords(String input) {
        return stringLiteralArray(input).length;
    }

    public static String maxWord(String input) {
        String[] strings = stringLiteralArray(input);
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

    public static String minWord(String input) {
        String[] strings = stringLiteralArray(input);
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

    public static String[] stringLiteralArray(String input){
        input.trim();
        char[] chars = {'.', ',', ';', ':', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '?',
                '/', '$', '%', '"', '(', ')', '{', '}', '[', ']', '@', '-', '=', '+', '<', '>', '~',
                '#', '^', '*', '|'};
        char[] chars2 = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars[i] == chars2[j])
                    chars2[j] = ' ';
            }
        }
        input = new String(chars2);
        String[] strings = input.split("\\s+");
        return  strings;
    }
}
