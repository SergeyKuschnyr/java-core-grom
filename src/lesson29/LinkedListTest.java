package lesson29;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Kushn_000 on 26.09.2017.
 */
public class LinkedListTest {
    public Set useHashSet() {

        HashSet<Order> hashSet = new HashSet<>();
        HashSet<Order> orderHashSet = new HashSet<>();

        Order order1 = new Order(1001L, 10, "USD", "barby", "toys");
        Order order2 = new Order(1002L, 20, "USD", "spider", "toys");
        Order order3 = new Order(1004L, 70, "EUR", "bushing", "supply");
        Order order4 = new Order(1005L, 50, "EUR", "scotch", "office");
        Order order5 = new Order(1003L, 30, "USD", "antenna", "3g");

        System.out.println("add(E e)-------------------------------");
        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);
        hashSet.add(order4);
        hashSet.add(order5);

        orderHashSet.add(order2);
        orderHashSet.add(order3);
        orderHashSet.add(order4);

        System.out.println(hashSet);
        System.out.println();
        System.out.println(orderHashSet);
        System.out.println();

        System.out.println("remove(E e)-----------------------------");
        hashSet.remove(order4);

        System.out.println(hashSet);
        hashSet.add(order4);
        System.out.println();

        System.out.println("retailAll(Collection c)------------------");
        hashSet.retainAll(orderHashSet);

        System.out.println(hashSet);
        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);
        hashSet.add(order4);
        hashSet.add(order5);
        System.out.println();

        System.out.println("Object[] toArray()------------------------");
        Object[] orders = hashSet.toArray();

        System.out.println(Arrays.toString(orders));
        System.out.println();

        System.out.println("size()-------------------------------------");
        System.out.println(hashSet.size());
        System.out.println();

        System.out.println("Iterator-----------------------------------");
        Iterator<Order> iterator = hashSet.iterator();
        for (; iterator.hasNext(); ) {
                System.out.println(iterator.next());
            }

        System.out.println();

        return hashSet;
    }
}
