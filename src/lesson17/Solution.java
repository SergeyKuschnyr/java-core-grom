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
        if (input != null) {
            input.trim();
            char[] chars = input.toCharArray();
            int count = 0;
            boolean bl = true;
            for (char ch : chars) {
                if (Character.isLetter(ch)) {
                    bl = true;
                    continue;
                }
                if (bl) {
                    count++;
                    bl = false;
                }
            }
            return count;
        }
        return 0;
    }

    public static String maxWord(String input) {
        if (input != null) {
            input.trim();
            char[] chars = input.toCharArray();
            int count = 0;
            int maxLength = 0;
            String tempWord = "";
            String word = "";
            for (char ch : chars) {
                if (Character.isLetter(ch)) {
                    count++;
                    tempWord += Character.toString(ch);
                } else {
                    if (count > maxLength) {
                        maxLength = count;
                        word = tempWord;
                    }
                    count = 0;
                    tempWord = "";
                }
            }
            return word;
        }
        return null;
    }

    public static String minWord(String input) {
        if (input != null) {
            input.trim();
            char[] chars = input.toCharArray();
            int count = 0;
            int maxLength = 0;
            String tempWord = "";
            String word = "";
            for (char ch : chars) {
                if (Character.isLetter(ch)) {
                    count++;
                    tempWord += Character.toString(ch);
                } else {
                    if (count < maxLength) {
                        maxLength = count;
                        word = tempWord;
                    }
                    count = 0;
                    tempWord = "";
                }
            }
            return word;
        }
        return null;
    }

    public static String mostCountedWord(String input) {

        return null;
    }
}
