package lesson17.hw3;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff";

        String string2 = "раз два два три три три три три пять пять пять пять пять " +
                "восемь восемь восемь восемь восемь восемь восемь 1111111111111111";
        String string3 = "qwerty";
        String string4 = "раз два три пять восемь 1111111111111111";

//        String wrongString = "!@#$% +_)(* *&^%$";
//        String internetAddress = "http://gromcode.com";

        System.out.println("\"6789 asdfgh\"");
        System.out.println(mostCountedWord("6789 asdfgh"));
        System.out.println("\"asdfgh 6789\"");
        System.out.println(mostCountedWord("asdfgh 6789"));
        System.out.println("\"Open the source code oftyui the definition for editing " +
                "and close the quick   definition lot  ffffffffffffffffffffffffffffffffff\"");
        System.out.println(mostCountedWord(string));
        System.out.println("\"раз два два три три три три три пять пять пять пять пять " +
                "восемь восемь восемь восемь восемь восемь восемь 1111111111111111\"");
        System.out.println(mostCountedWord(string2));
        System.out.println("\"qwerty\"");
        System.out.println(mostCountedWord(string3));
        System.out.println("\"раз два три пять восемь 1111111111111111\"");
        System.out.println(mostCountedWord(string4));
    }

    public static String mostCountedWord(String input) {
        // Проверяем входную строку на null и пустую строку, если одно из этих условий
        // выполняется возвращаем null
        if (input == null || input.length() == 0) {
            return null;
        }
        //Разбиваем строку на слова. Если получаем одно слово и оно состоит из букв - возвращаем его,
        //в противном случее null
        String[] strings = input.split(" ");
        if (strings.length == 1) {
            if (checkLetter(strings[0])) {
                return strings[0];
            }
            return null;
        }
        //Если слов два и больше....
        int count = 0;
        int count2 = 0;
        String tempString = "";
        //...проверяем на количество совпадений каждое слово. Использую для этого вложенный цикл, учитыва,
        //то, что бы слова не проверялись сами с собой (i != j).
        //во внутреннем цикле проверяем соблюдение двух условий: слово должно быть из букв и
        //сравниваемые слова должны быть равны. Если эти условия выполняются увеличиваем счетчик count
        //на 1. Таким образом полный проход одного внутреннего цикла дает нам количество совпадений
        // по одному слову - это число храниться в count.
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; i != j && j < strings.length; j++) {
                if (checkLetter(strings[i]) && strings[i].equals(strings[j])) {
                    count++;
                }
            }
            //Выйдя из внутреннего цикла, и зная колличество совпадений (count) сравниваем это колличество
            //c максимальным колличеством совпадений на данной итеррации, которое храниться в переменной
            // count2. Если count > count2 сохраняем значение из count в count2 и соответственно сохраняем
            // слово, длина которого оказалась больше значения хранимого в count2,  в переменной tempString.
            if (count > count2) {
                count2 = count;
                tempString = strings[i];
            }
            //В конце каждой итеррации внешнего цикла обнуляем count
            count = 0;
        }
        //Если слов не найденно, а соответсвенно значение tempString осталось пустым - возвращаем null,
        // в противном случае возвращаем tempString
        if (tempString == "") {
            return strings[0];
        }
        return tempString;
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

//    public static boolean qwerty(String str1, String str2) {
//        if (str1.length() != str2.length())
//            return false;
//        char[] ch1 = str1.toCharArray();
//        char[] ch2 = str2.toCharArray();
//        for (int i = 0; i < ch1.length; i++) {
//                if (ch1[i] != ch2[i]) {
//                    return false;
//                }
//            }
//        return true;
//    }
}
