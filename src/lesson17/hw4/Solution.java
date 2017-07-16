package lesson17.hw4;

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
        String internetAddress = "https://www.gromcode.com";

        System.out.println(validate(internetAddress));
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
