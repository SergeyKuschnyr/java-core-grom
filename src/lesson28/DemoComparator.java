package lesson28;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Kushn_000 on 23.09.2017.
 */
public class DemoComparator {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test7", "qwert9", true,
                new Date(1999, 9, 1));
        Capability capability2 = new Capability(1005, "test2", "qwerty7", false,
                new Date(1976, 4, 23));
        Capability capability3 = new Capability(900, "test9", "qwerty12", true,
                new Date(2017, 8, 12));
        Capability capability4 = new Capability(950, "test1", "qwerty3", false,
                new Date(2007, 7, 30));


        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(null);
        capabilities.add(capability4);

        System.out.println(capabilities);
        try {
            capabilities.sort(new IsActiveComparator());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
        System.out.println(capabilities);

        System.out.println();

        System.out.println(capabilities);
        try {
            capabilities.sort(new DateComparator());
        } catch (NullPointerException npe) {
            System.out.println(npe.getMessage());
        }
        System.out.println(capabilities);

        System.out.println();

        System.out.println(capabilities);
        try {
            capabilities.sort(new FullComparator());
        }catch (NullPointerException npe){
            System.out.println(npe.getMessage());
        }
        System.out.println(capabilities);
    }
}
