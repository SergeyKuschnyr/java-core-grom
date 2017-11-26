package lesson34.transferFileContent;


/**
 * Created by Kushn_000 on 25.11.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        try {
            solution.transferFileContent("C:/Users/Kushn_000/Desktop/service_routing.txt",
                    "C:/Users/Kushn_000/Desktop/test.txt");
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
