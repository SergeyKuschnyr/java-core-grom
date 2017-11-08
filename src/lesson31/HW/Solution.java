package lesson31.HW;

import java.util.*;
/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Solution {

    public Map<Character, Integer> countSymbols(String text) {
        char[] chars = text.toCharArray();

        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char ch : chars) {
            characterArrayList.add(ch);
        }

        Map<Character, Integer> tempChar = new Hashtable<>();

        for (Character ch : characterArrayList) {
            if (Character.isLetter(ch))
                tempChar.put(ch, tempChar.get(ch) == null ? 1 : tempChar.get(ch) + 1);
        }
        return tempChar;
    }

    public Map words(String text) {
        String[] strings = text.split(" ");

        ArrayList<String> stringAL = new ArrayList<>();
        for (String str : strings) {
            stringAL.add(str);
        }

        Map<String, Integer> htArray = new Hashtable<>();

        for (String string : stringAL) {
            if (string.length() <= 2) {
                continue;
            }
            if (!Character.isLetter(string.charAt(string.length() - 1))) {
                string = string.substring(0, string.length() - 1);
            }
            if (!wordValidate(string)) {
                continue;
            }

            htArray.put(string, htArray.get(string) == null ? 1 : htArray.get(string) + 1);
        }
        return htArray;
    }

    private boolean wordValidate(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch) && ch != '-') {
                return false;
            }
        }
        return true;
    }
}