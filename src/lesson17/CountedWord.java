package lesson17;

/**
 * Created by Kushn_000 on 14.07.2017.
 */
public class CountedWord {
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
}
