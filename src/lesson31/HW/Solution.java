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

        badWordSearch(stringAL);

        for (String string : stringAL) {
            htArray.put(string, htArray.get(string) == null ? 1 : htArray.get(string) + 1);
        }
        return htArray;
    }

    private void badWordSearch(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() <= 2) {
                strings.remove(i);
                i--;
                continue;
            }

            if (!Character.isLetter(strings.get(i).charAt(strings.get(i).length() - 1))) {
                strings.add(strings.get(i).substring(0, strings.get(i).length() - 1));
                strings.remove(i);
                i--;
                continue;
            }

            if (!wordValidate(strings.get(i))) {
                strings.remove(i);
                i--;
            }
        }
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