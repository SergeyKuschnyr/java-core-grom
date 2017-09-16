package lesson26.HW;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 16.09.2017.
 */
public class Demo {
    public static void main(String[] args) {
        ArrayListTest arrayListTest = new ArrayListTest();

        ArrayList arrayList = arrayListTest.useList();

        System.out.println("In main method: " + arrayList.toString());
    }
}
