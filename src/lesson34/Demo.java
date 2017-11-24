package lesson34;

import java.io.IOException;

/**
 * Created by Kushn_000 on 23.11.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();
        solution.copyFileContent("C:/Users/Kushn_000/Desktop/service_routing.txt",
                "C:/Users/Kushn_000/Desktop/test.txt");
    }

}
