package lesson31.HW;

import java.util.*;
/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class Solution {

    public Map<Character, Integer> countSymbols(String text) {
        ArrayList<Character> characterArrayList = new ArrayList<>();
        for (char ch : text.toCharArray()) {
            characterArrayList.add(ch);
        }
        Collections.sort(characterArrayList);
        Map<Character, Integer> tempChar = new Hashtable<>();

        char ch = characterArrayList.get(0);
        int counter = 0;

        for (int i = 0; i < characterArrayList.size(); i++){
            if (ch == characterArrayList.get(i)){
                counter++;
                if (i == characterArrayList.size() - 1){
                    tempChar.put(ch, counter);
                }
            }else {
                tempChar.put(ch, counter);
                counter = 1;
                ch = characterArrayList.get(i);
            }
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