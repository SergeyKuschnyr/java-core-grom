package lesson17;

/**
 * Created by Kushn_000 on 07.07.2017.
 */
public class Solution {
    public static void main(String[] args) {
        String string = "Open the source code of the definition for editing and close the quick definition";
        System.out.println(countWords(string));
    }
    public static int countWords(String input) {
//        input.trim();
//        char[] chars = input.toCharArray();
//        int index = 0;
//        for (char ch : chars) {
//            if (ch == ' ')
//                index ++;
//        }
//        return index + 1;

        input.trim();
        String[] strings = input.split(" ");
        return strings.length;
    }
}
