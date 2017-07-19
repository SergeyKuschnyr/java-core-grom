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
        String internetAddress = "http://www.gromcode.com";
        //String internetAddress2 = "http://qwerty.asdfgh";

        System.out.println(validate(internetAddress));
        //System.out.println(validate(internetAddress2));
    }

    public static boolean validate(String address) {
        if (!(address.substring(0, 7).equals("http://") ||
                address.substring(0, 8).equals("https://") ||
                address.substring(0, 11).equals("http://www.") ||
                address.substring(0, 12).equals("https://www.")
        ))
            return false;

        if (!(address.substring(address.length() - 4).equals(".com") ||
                address.substring(address.length() - 4).equals(".org") ||
                address.substring(address.length() - 4).equals(".net"))) {
            return false;
        }

        if (!(checkLetter(address.substring(7, address.length() - 4)) ||
                checkLetter(address.substring(8, address.length() - 4)) ||
                checkLetter(address.substring(11, address.length() - 4)) ||
                checkLetter(address.substring(12, address.length() - 4))
        ))
            return false;
        return true;
    }


    public static boolean checkLetter(String name) {
        char[] chars = name.toCharArray();
        for (char c : chars) {
            if (!(Character.isLetter(c) || Character.isDigit(c))) {
                return false;
            }
        }
        return true;
    }
}
