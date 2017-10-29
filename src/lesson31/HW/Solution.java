package lesson31.HW;

import java.util.*;

/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Solution {

    public Map<Character, Integer> countSymbols(String text) {

        char[] chars = text.toCharArray();
        Map<Character, Integer> tempChar = new Hashtable<>();

        int count = 0;

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        count++;
                        chars[j] = ' ';
                    }
                }
                tempChar.put(chars[i], count + 1);
            }
            chars[i] = ' ';
            count = 0;
        }
        return tempChar;
    }

    public Map words(String text) {
        String[] strArray = text.split(" ");
        Map<String, Integer> strInfo = new Hashtable<>();

        deleteWrongWord(strArray);

        int count = 0;

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] != null) {
                for (int j = i + 1; j < strArray.length; j++) {
                    if (strArray[i].equals(strArray[j])) {
                        count++;
                        strArray[j] = null;
                    }
                }
                strInfo.put(strArray[i], count + 1);
            }
            strArray[i] = null;
            count = 0;
        }
        return strInfo;
    }

    private void deleteWrongWord(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() <= 2) {
                strArray[i] = null;
                continue;
            }
            if (!Character.isLetter(strArray[i].charAt(strArray[i].length() - 1))) {
                strArray[i] = strArray[i].substring(0, (strArray[i].length() - 1));
            }
            for (int j = 0; j < strArray[i].length(); j++) {
                if (!Character.isLetter(strArray[i].charAt(j))) {
                    if (!(strArray[i].charAt(j) == '-')) {
                        strArray[i] = null;
                        break;
                    }
                }
            }
        }
    }
}
