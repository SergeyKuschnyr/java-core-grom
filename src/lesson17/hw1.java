package lesson17;

/**
 * Created by Kushn_000 on 14.07.2017.
 */
public class hw1 {
    public static int countWords(String input) {
        String[] strings = input.split(" ");
        if (strings.length == 0) {
            return 0;
        }
        int count = 0;
        for (String string : strings) {
            if (string.length() > 0 && checkLetter(string)) {
                count++;
            }
        }
        return count;
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
