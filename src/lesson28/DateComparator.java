package lesson28;

import java.util.Comparator;

/**
 * Created by Kushn_000 on 23.09.2017.
 */
public class DateComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) throws NullPointerException{
        System.out.println("DateComparator i used");
//        if (o1.getDateCreated().before(o2.getDateCreated()))
//            return -1;
//        else if (o1.getDateCreated().equals(o2.getDateCreated()))
//            return 0;
//        else
//            return 1;
        if (o1 == null || o2 == null)
            throw new NullPointerException("One or more the fields of collection is null");
        return o1.getDateCreated().compareTo(o2.getDateCreated());
    }
}
