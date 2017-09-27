package lesson29;

import java.util.Set;

/**
 * Created by Kushn_000 on 26.09.2017.
 */
public class Demo {
    public static void main(String[] args) {
        LinkedListTest linkedListTest = new LinkedListTest();
        Set set = linkedListTest.useHashSet();
        System.out.println("Return value-------------------------------");
        System.out.println(set);
    }
}
