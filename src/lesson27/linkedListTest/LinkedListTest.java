package lesson27.linkedListTest;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Kushn_000 on 20.09.2017.
 */
public class LinkedListTest {
    public LinkedList useList() {
        LinkedList<Order> linkedList = new LinkedList<>();

        Order order = new Order(1002, 10, "qwerty1", "toy1", "rozetka");
        //        add(E e)
        linkedList.add(order);
        linkedList.add(new Order(1003, 40, "qwerty2", "toy2", "citrus"));
        linkedList.add(new Order(1004, 20, "qwerty3", "toy3", "ttt"));
        linkedList.add(new Order(1006, 30, "qwerty6", "toy6", "epitsentr"));

        System.out.println(linkedList.toString());
        System.out.println();
        //        add(int index, E element)
        linkedList.add(1, new Order(1005, 70, "qwerty4", "toy4", "inbox"));

        System.out.println(linkedList.toString());
        System.out.println();
        //        remove(int index)
        linkedList.remove(2);

        System.out.println(linkedList.toString());
        System.out.println();
        //        remove(Object o)
        linkedList.remove(order);

        System.out.println(linkedList.toString());
        System.out.println();
        //        addAll(Collection c)
        linkedList.addAll(linkedList);

        System.out.println(linkedList.toString());
        System.out.println();
        //        subList(int fromIndex, int toIndex)
        System.out.println(linkedList.subList(1, 3).toString());
        System.out.println();
        //        set(int index, E element)
        linkedList.set(0, order);

        System.out.println(linkedList.toString());
        System.out.println();
        //        boolean contains(Object o)
        System.out.println(linkedList.contains(order));
        System.out.println();

        LinkedList linkedList1 = new LinkedList();
        linkedList1.addAll(linkedList);
        //        Object[] toArray()
        Object[] o = linkedList.toArray();

        System.out.println(Arrays.toString(o));
        System.out.println();
        //        clear()
        linkedList.clear();

        System.out.println(linkedList.toString());

        return linkedList1;
    }
}
