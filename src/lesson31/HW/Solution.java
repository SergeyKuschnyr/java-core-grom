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

        for (int i = 0; i < stringAL.size(); i++) {
            if (stringAL.get(i).length() <= 2) {
                stringAL.remove(i);
                continue;
            }
            if (!Character.isLetter(stringAL.get(i).charAt(stringAL.get(i).length() - 1))) {
                String str = stringAL.get(i);
                stringAL.remove(i);
                if (stringAL.get(i).length() - 1 >= i) {
                    stringAL.set(i, str.substring(0, (str.length() - 2)));
                }
                stringAL.add(str.substring(0, (str.length() - 2)));
            }
            if (digitInWord(stringAL.get(i))) {
                stringAL.remove(i);
                continue;
            }
            htArray.put(stringAL.get(i), htArray.get(stringAL.get(i)) == null ? 1 : htArray.get(stringAL.get(i)) + 1);
        }
        return htArray;
    }

    private boolean digitInWord(String string) {
        char[] chars = string.toCharArray();
        for (char ch : chars) {
            if (!Character.isLetter(ch) && ch != '-') {
                return true;
            }
        }
        return false;
    }
}

