package lesson35.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 17.01.2018.
 */
public class DemoTest {
    public static void main(String[] args) {
//        ArrayList stringAL = new ArrayList();
//
//        method(stringAL);
//        method(stringAL);
//        method(stringAL);
//
//        System.out.println("stringAL: " + stringAL);

        int i = 7;
        String s = "qwerty";
        Map<String, String> mapCollection = new HashMap<>();
        mapCollection.put("qwerty", "QWERTY");
        mapCollection.put("qwerty2", "QWERTY2");
        mapCollection.put("qwerty3", "QWERTY3");

        System.out.println("before: " + mapCollection);

        changeValue(i, s, mapCollection);

        System.out.println("i: " + i +"  s: " + s);
        System.out.println("after: " + mapCollection);
    }

    public static void changeValue(int i, String s, Map mc){
        i = 0;
        s = "";
        mc.clear();
    }

    public  static void method (ArrayList arrayList){
        arrayList.add("qwerty");
    }
}
