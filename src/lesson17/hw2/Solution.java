package lesson17.hw2;

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

        String wrongString = "!@#$% +_)(* *&^%$";
//    String internetAddress = "http://gromcode.com";
        System.out.println(hw2.maxWord(string));
        System.out.println("------------------------------");
        System.out.println(hw2.maxWord("test"));
        System.out.println("------------------------------");
        System.out.println(hw2.minWord(string));
        System.out.println(hw2.maxWord(wrongString));
    }
}
