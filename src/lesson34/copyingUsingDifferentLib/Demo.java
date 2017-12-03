package lesson34.copyingUsingDifferentLib;

/**
 * Created by Kushn_000 on 01.12.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Solution solution = new Solution();

        solution.copyFileContent("C:/Users/Kushn_000/Desktop/Для Юры/testout.txt",
                "C:/Users/Kushn_000/Desktop/Для Юры/testin.txt");
    }
}
