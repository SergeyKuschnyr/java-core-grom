package lesson35.demo;

import java.util.ArrayList;

/**
 * Created by Kushn_000 on 17.01.2018.
 */
public class DemoTest {
    public static void main(String[] args) {
        ArrayList stringAL = new ArrayList();

        method(stringAL);
        method(stringAL);
        method(stringAL);

        System.out.println("stringAL: " + stringAL);
    }

    public  static void method (ArrayList arrayList){
        arrayList.add("qwerty");
    }
}
