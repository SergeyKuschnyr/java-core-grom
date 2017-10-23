package lesson31;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kushn_000 on 22.10.2017.
 */
public class MapIntro {
    public static void main(String[] args) {
        Map<String, Building> map = new HashMap<>();

        Building building1 = new Building("School", 5);
        Building building2 = new Building("Hospital", 8);

        map.put("TTT222", building1);
        map.put("PG55PR", building2);

        System.out.println(map);
        System.out.println();
        System.out.println(map.keySet());
        System.out.println();
        System.out.println(map.values());
        System.out.println();
        System.out.println(map.get("PG55PR"));
        System.out.println();
        map.remove("TTT222");
        System.out.println(map);

    }
}
