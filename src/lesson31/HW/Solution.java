package lesson31.HW;

import java.util.*;

/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Solution {
    public Hashtable<Character, Integer> countSymbols(String text) {
        char[] chars = text.toCharArray();
        Hashtable<Character, Integer> tempChar = new Hashtable<>();

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
        Hashtable<String, Integer> strInfo = new Hashtable<>();

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
            char[] chars = strArray[i].toCharArray();
            for (char ch : chars) {
                if (Character.isDigit(ch)) {
                    strArray[i] = null;
                    break;
                }
            }
        }
    }
}


//        char[] chars = text.toCharArray();
//        Character[] characters = new Character[chars.length];
//        for (int i = 0; i < characters.length; i++){
//            characters[i] = chars[i];
//        }
//        Hashtable<Character, Integer> tempChar = new Hashtable<>();
//
//        int count = 0;
//
//        for (int i = 0; i < characters.length; i++) {
//            if (characters[i] != null && Character.isLetter(characters[i])) {
//                for (int j = i + 1; j < characters.length; j++) {
//                    if (characters[i].equals(characters[j])) {
//                        count++;
//                        characters[j] = null;
//                    }
//                }
//                tempChar.put(characters[i], count + 1);
//            }
//            characters[i] = ' ';
//            count = 0;
//        }
//        return tempChar;


//    private <T extends Arrays>void method(T[] t, int i, int count){
//        for (int j = i + 1; j < T.; j++) {
//            if (T[i].equals(T[j])) {
//                count++;
//                characters[j] = null;
//            }
//        }
//        tempChar.put(characters[i], count + 1);
//    }