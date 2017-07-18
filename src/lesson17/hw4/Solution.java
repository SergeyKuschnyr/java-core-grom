package lesson17.hw4;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff";

        String string2 = "\"Открыв дверь, Путин протягивает руку. Возможно, он хотел либо помочь " +
                "пассажиру выйти, либо взять пиджак с заднего сидения машины, поскольку он одет " +
                "в рубашку, - написал \"Дождь\" в расширенном варианте заметки. - Лица пассажира " +
                "не видно, но на более качественных кадрах, которые \"Дождю\" предоставило " +
                "агентство Ruptly, видно, что на коленях у человека красная сумка. Сам этот человек " +
                "одет неофициально - видно, что он в одежде с коротким рукавом. Неясно, мужчина это " +
                "или женщина\".";

//    String wrongString = "!@#$% +_)(* *&^%$";
        //String internetAddress = "http://g.com";
        String internetAddress = "https://www.gromcode.com";
        //String internetAddress2 = "http://qwerty.asdfgh";

        System.out.println(validate(internetAddress));
        //System.out.println(validate(internetAddress2));
    }

    public static boolean validate(String address) {
        if (!(address.substring(0, 7).equals("http://") || address.substring(0, 8).equals("https://")))
            return false;

        String[] strings = address.split("\\.");
        System.out.println(Arrays.toString(strings));

        if (!(strings[strings.length - 1].equals("com") ||
                strings[strings.length - 1].equals("org") ||
                strings[strings.length - 1].equals("net"))) {
            return false;
        }

        System.out.println("---------------------------");
        if (strings.length == 3) {
            if (strings[0].equals("https://www") && checkLetter(strings[1]) ||
                    strings[0].equals("http://www") && checkLetter(strings[1])) {
                return true;
            }
            return false;
        }
        if (strings[0].substring(0, 7).equals("http://") && checkLetter(strings[0].substring(7))) {
            return true;
        }

        if (strings[0].substring(0, 8).equals("https://") && checkLetter(strings[0].substring(8))) {
            return true;
        }

        return false;
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
