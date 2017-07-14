package lesson17;

/**
 * Created by Kushn_000 on 14.07.2017.
 */
public class ExtremeWord {
    public static String maxWord(String input) {
        if (input == null || input.length() < 5) {
            return null;
        }
        String[] strings = input.split(" ");
        if (!(strings.length > 1)) {
            return null;
        }
        String maxString = "";
        //если во входящих данных нет вообще слов подходящих, что будет?
        for (String string : strings) {
            //ты { скобки потерял после ифов , и у тебя maxString = string; всегда выполняеьтся
            if (string.length() > 0 && Solution.checkLetter(string)) {
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
        if (input == null || input.length() < 5)
            return null;
        String[] strings = input.split(" ");
        if (!(strings.length > 1))
            return null;
        String minString = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        for (String string : strings) {
            if (string.length() > 0 && Solution.checkLetter(string))
                if (string.length() < minString.length())
                    minString = string;
        }
        return minString;
    }
}
