package lesson17.hw2;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff";

//        String string2 = "\"Открыв дверь, Путин протягивает руку. Возможно, он хотел либо помочь " +
//                "пассажиру выйти, либо взять пиджак с заднего сидения машины, поскольку он одет " +
//                "в рубашку, - написал \"Дождь\" в расширенном варианте заметки. - Лица пассажира " +
//                "не видно, но на более качественных кадрах, которые \"Дождю\" предоставило " +
//                "агентство Ruptly, видно, что на коленях у человека красная сумка. Сам этот человек " +
//                "одет неофициально - видно, что он в одежде с коротким рукавом. Неясно, мужчина это " +
//                "или женщина\".";

        String wrongString = "!@#$% +_)(* *&^%$";
//    String internetAddress = "http://gromcode.com";
        //System.out.println(maxWord(string));
        //System.out.println("------------------------------");
        //System.out.println(maxWord("test"));
        //System.out.println("------------------------------");
        System.out.println(minWord(string));
        System.out.println(minWord(wrongString));
        System.out.println(minWord(""));
        System.out.println(minWord("a s"));
        System.out.println(minWord("8 6"));
        System.out.println(minWord("\\\\ \\\\"));
        System.out.println(minWord(": ;"));
        System.out.println(minWord("4 g"));
        System.out.println(minWord(null));

        //System.out.println(maxWord(wrongString));
    }

    public static String maxWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] strings = input.split(" ");

        String maxString = "";

        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string)) {
                if (string.length() > maxString.length()) {
                    maxString = string;
                }
            }
        }

        if (maxString == "") {
            return null;
        }
        return maxString;
    }

    public static String minWord(String input) {
        if (input == null || input.length() == 0) {
            return null;
        }

        String[] strings = input.split(" ");

        String minString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string)) {
                if (string.length() < minString.length()) {
                    minString = string;
                }
            }
        }
        if (minString == "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa") {
            return null;
        }
        return minString;
    }

    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
}
