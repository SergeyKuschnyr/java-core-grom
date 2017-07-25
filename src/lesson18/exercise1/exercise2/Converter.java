package lesson18.exercise1.exercise2;

/**
 * Created by Kushn_000 on 25.07.2017.
 */
public class Converter {
    public static void main(String[] args) {
        System.out.println(intToString(111231));
        System.out.println(intToString(0));
        System.out.println(intToString(-67));
        System.out.println(intToString(89/67));
        System.out.println(intToString(89%67));

        System.out.println(stringToInt("11"));
        System.out.println(stringToInt("1050a"));
        System.out.println(stringToInt(""));
        System.out.println(stringToInt(null));
        System.out.println(stringToInt("11/3"));
        System.out.println(stringToInt("11" + "45"));
        System.out.println(stringToInt("11df" + "67"));
        System.out.println(stringToInt(intToString(678)));

        System.out.println(intToString(111231));
        System.out.println(stringToInt("11"));

    }

    public static String intToString(int input) {
        return String.valueOf(input);
    }

    public static int stringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            System.out.println(input + " can not be converted to int");
            return 0;
        }
    }
}
