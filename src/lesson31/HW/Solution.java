package lesson31.HW;

import java.util.*;

/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Solution {
    public Hashtable<Character, Integer> countSymbols(String text) {

        char[] chars = text.toCharArray();
        Hashtable<Character, Integer> tempChar = new Hashtable<>();

        // Создаю массив ссылок, чтобы далее иметь одинаковые куски кода и заменить их методом (collectionCreating)
        Character[] characters = new Character[chars.length];
        for (int i = 0; i < characters.length; i++) {
            characters[i] = chars[i];
        }

        int count = 0;

        for (int i = 0; i < characters.length; i++) {
            if (characters[i] != null && Character.isLetter(characters[i])) {
                collectionCreating(characters, i, count, tempChar);
            }
            characters[i] = ' ';
            count = 0;
        }
        return tempChar;
    }

    public Map words(String text) {
        String[] strArray = text.split(" ");
        Hashtable<String, Integer> strInfo = new Hashtable<>();

        // Помещаю часть кода в метод, так думаю понятнее и читабельнее
        deleteWrongWord(strArray);

        int count = 0;

        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i] != null) {
                collectionCreating(strArray, i, count, strInfo);
            }
            strArray[i] = null;
            count = 0;
        }
        return strInfo;
    }

    private void deleteWrongWord(String[] strArray) {
        for (int i = 0; i < strArray.length; i++) {
            char[] chars = strArray[i].toCharArray();
            for (char ch : chars) {
                if (Character.isDigit(ch)) {
                    strArray[i] = null;
                    break;
                }
            }
        }
    }

    private <T> void collectionCreating(T[] t, int i, int count, Hashtable tempChar) {
        for (int j = i + 1; j < t.length; j++) {
            if (t[i].equals(t[j])) {
                count++;
                t[j] = null;
            }
        }
        tempChar.put(t[i], count + 1);
    }
}
