package lesson27.performance;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

/**
 * Created by Kushn_000 on 20.09.2017.
 */
public class TestPerformance {
    public static void main(String[] args) {
        testAddMethod();

        testRemoveMethod();

        testGetMethod();
    }

    private static void testAddMethod() {
        ArrayList<String> arrayList = new ArrayList<>();

        Date start = new Date();

        for (int i = 0; i < 100000; i++){
            arrayList.add(i, String.valueOf(i));
        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("add - array list: " + diff);

        //linked list
        LinkedList<String> linkedList = new LinkedList<>();

        Date start1 = new Date();

        for (int i = 0; i < 100000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("add - array list: " + diff);
    }

    private static void testRemoveMethod() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++){
            arrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for (int i = 0; i < 97000; i++){
            arrayList.remove(3000);
        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("remove - array list: " + diff);

        //linked list
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date start1 = new Date();

        for (int i = 0; i < 97000; i++){
            linkedList.remove(3000);
        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("remove - linked list: " + diff);
    }

    private static void testGetMethod() {
        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < 100000; i++){
            arrayList.add(i, String.valueOf(i));
        }

        Date start = new Date();

        for (int i = 0; i < 100000; i++){
            arrayList.get(5000);
        }

        Date finish = new Date();

        long diff = finish.getTime() - start.getTime();
        System.out.println("get - array list: " + diff);

        //linked list
        LinkedList<String> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++){
            linkedList.add(i, String.valueOf(i));
        }

        Date start1 = new Date();

        for (int i = 0; i < 100000; i++){
            linkedList.get(50000);
        }

        Date finish1 = new Date();

        diff = finish1.getTime() - start1.getTime();
        System.out.println("get - linked list: " + diff);
    }
}
