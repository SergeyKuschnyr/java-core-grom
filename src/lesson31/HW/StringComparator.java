package lesson31.HW;

import java.util.Comparator;

/**
 * Created by Kushn_000 on 30.10.2017.
 */
public class StringComparator implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        return o1.compareTo(o2);
    }
}
