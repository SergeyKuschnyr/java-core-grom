package lesson28;

import java.util.Comparator;

/**
 * Created by Kushn_000 on 23.09.2017.
 */
public class IsActiveComparator implements Comparator<Capability> {

    public IsActiveComparator() {
    }

    @Override
    public int compare(Capability o1, Capability o2) throws NullPointerException{
        System.out.println("IsActiveComparator i used");
        if (o1 == null || o2 == null)
            throw new NullPointerException("One or more the fields of collection is null");
        if (o1.isActive() && !o2.isActive())
            return -1;
        else if (o1.isActive() && o2.isActive() || !o1.isActive() && !o2.isActive())
            return 0;
        else
            return 1;
    }
}
