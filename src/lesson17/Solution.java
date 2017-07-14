package lesson17;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 07.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the. source; code, oftyui123 the#, definition: for, editing " +
                "and close, the quick.   definition 567 lot <= ";
        String string2 = "\"Открыв дверь, Путин протягивает руку. Возможно, он хотел либо помочь пассажиру выйти, либо взять пиджак с заднего сидения машины, поскольку он одет в рубашку, - написал \"Дождь\" в расширенном варианте заметки. - Лица пассажира не видно, но на более качественных кадрах, которые \"Дождю\" предоставило агентство Ruptly, видно, что на коленях у человека красная сумка. Сам этот человек одет неофициально - видно, что он в одежде с коротким рукавом. Неясно, мужчина это или женщина\".";
        // String string3 = null;
        String wrongString = "!@#$% +_)(* *&^%$";
        String internetAddress = "http://gromcode.com";

        System.out.println(countWords(string));
        System.out.println(maxWord(string));
        System.out.println(minWord(string));
        System.out.println(maxWord(wrongString));
        System.out.println("--------------------------------");
        System.out.println(mostCountedWord(string2));
        System.out.println("--------------------------------");

        System.out.println(validate(internetAddress));

        //       System.out.println(countWords(string2));
        //   System.out.println(maxWord(string2));
//        System.out.println(minWord(string2));

//        System.out.println(countWords(string3));
//        System.out.println(maxWord(string3));
//        System.out.println(minWord(string3));
    }

    public static int countWords(String input) {
        String[] strings = input.split(" ");
        if (strings.length == 0)
            return 0;
        int count = 0;
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                count++;
        }
        return count;
    }

    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c))
                return false;
        }
        return true;
    }


    public static String maxWord(String input) {
        if (input == null || input.length() < 5)
            return null;
        String[] strings = input.split(" ");
        if (!(strings.length > 1))
            return null;
        String maxString = "";
        //если во входящих данных нет вообще слов подходящих, что будет?
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                if (string.length() > maxString.length())
                    maxString = string;
        }
        if (maxString == "")
            return null;
        return maxString;
    }

    public static String minWord(String input) {
        if (input == null || input.length() < 5)
            return null;
        String[] strings = input.split(" ");
        if (!(strings.length > 1))
            return null;
        String minString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string))
                if (string.length() < minString.length())
                    minString = string;
        }
        return minString;
    }

    public static String mostCountedWord(String input) {
        String[] strings = input.split(" ");
        if (strings.length < 2)
            return null;
        int count = 0;
        int count2 = 0;
        String tempString = "";
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length - 1; j++) {
                if (strings[i].equals(strings[j])) {
                    count++;
                }
            }
            if (count > count2) {
                count2 = count;
                tempString = strings[i];
                count = 0;
            }
        }
        return tempString;
    }

    public static boolean validate(String address) {
        if (address != null && address.length() > 11) {
            String[] strings = address.split("//");
            if (strings.length != 2)
                return false;

            if (!(strings[0].equals("http:") || strings[0].equals("https:")))
                return false;

            String[] strings1 = strings[1].split("\\.");
            if (!(1 < strings1.length && strings1.length < 4))
                return false;

            int i = 0;
            if (strings1.length == 3) {
                if (!strings1[0].equals("www"))
                    return false;
                i = 1;
            }

            char[] ch = strings1[i].toCharArray();
            for (char c : ch)
                if (!Character.isLetter(c))
                    return false;

            String[] zoneArr = {"com", "org", "net"};
            for (String str : zoneArr)
                if (str.equals(strings1[i + 1]))
                    return true;
            return false;
        }
        return false;
    }
}


