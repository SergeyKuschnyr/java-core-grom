package lesson26.HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kushn_000 on 16.09.2017.
 */
public class ArrayListTest {

    public ArrayList useList() {
        ArrayList arrayList = new ArrayList();

        Order order = new Order(1002, 10, "qwerty1", "toy1", "rozetka");
        arrayList.add(order);
        arrayList.add(new Order(1003, 40, "qwerty2", "toy2", "citrus"));
        arrayList.add(new Order(1004, 20, "qwerty3", "toy3", "ttt"));
        arrayList.add(new Order(1006, 30, "qwerty6", "toy6", "epitsentr"));

        //arrayList.add(new Order(1005, 70, "qwerty4", "toy4", "inbox"));

        System.out.println(arrayList.toString());
        System.out.println();

        arrayList.add(1, new Order(1005, 70, "qwerty4", "toy4", "inbox"));

        System.out.println(arrayList.toString());
        System.out.println();

        arrayList.remove(2);

        System.out.println(arrayList.toString());
        System.out.println();

        arrayList.remove(order);

        System.out.println(arrayList.toString());
        System.out.println();

        arrayList.addAll(arrayList);

        System.out.println(arrayList.toString());
        System.out.println();

        System.out.println(arrayList.subList(1, 3).toString());
        System.out.println();

        arrayList.set(0, order);

        System.out.println(arrayList.toString());
        System.out.println();

        System.out.println(arrayList.contains(order));
        System.out.println();

        arrayList.remove(5);
        ArrayList arrayList1 = new ArrayList();
        arrayList1.addAll(arrayList);

        Object[] o = arrayList.toArray();

        System.out.println("arrayList to array: " + Arrays.toString(o));
        System.out.println();

        arrayList.clear();

        System.out.println(arrayList.toString());

        return arrayList1;
    }
}
