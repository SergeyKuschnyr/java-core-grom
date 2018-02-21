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
        String s = "test";
        Map<String, String> mapCollection = new HashMap<>();
        mapCollection.put("qwerty", "QWERTY");
        mapCollection.put("qwerty2", "QWERTY2");
        mapCollection.put("qwerty3", "QWERTY3");

        //System.out.println("before: " + mapCollection);

        //changeValue(i, s, mapCollection);

        System.out.println("in main  s: " + s);
        //System.out.println("after: " + mapCollection);
        String str = s.replace("t", "AAAAA");
        System.out.println("in main  str: " + str);
        str = s.concat("_TEST");
        System.out.println("in main  str: " + str);
        System.out.println("in main  s: " + s);
        s += "77777777";
        System.out.println("in main  s: " + s);
        stringTest(s);
        System.out.println("in main after method  s: " + s);
        String str33 = new String(new char[9]);
        str33 = (new char[11]).toString();

    }

    public static void changeValue(int i, String s, Map mc){
        i = 0;
        System.out.println("in method before s: " + s);
        //s.replace("t", "t TEST");
        //s = "qwerty";
        //s.concat("_TEST");
        System.out.println("in method after s: " + s);
        mc.clear();
    }

    public static void stringTest(String s){
        //s += "77777777";
        s = "777777777777";
    }

    public  static void method (ArrayList arrayList){
        arrayList.add("qwerty");
    }
}





