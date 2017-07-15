package lesson17.hw4;

/**
 * Created by Kushn_000 on 15.07.2017.
 */
public class hw4 { public static boolean validate(String address) {
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
