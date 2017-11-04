package compareArray;

/**
 * Created by Kushn_000 on 04.11.2017.
 */
public class Demo {
    public static void main(String[] args) {
        int[] intArr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        int[] intArr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 89};

        Solution solution = new Solution();

        System.out.println(solution.compareIntArrays(intArr1, intArr2));

        String[] strings1 = {"one", "two", "tree", "four", "fife", "six"};
        String[] strings2 = {"one", "two", "tree", "four", "fife", "six", "seven"};

        System.out.println(solution.compareStringArrays(strings1, strings2));

        Employee employee1 = new Employee(23, "Ira", 2000);
        Employee employee2 = new Employee(32, "Kolya", 3000);
        Employee employee3 = new Employee(45, "Sveta", 2500);
        Employee employee4 = new Employee(23, "Ira", 2000);

        Employee[] employees1 = {employee1, employee2, employee3};
        Employee[] employees2 = {employee4, employee2, employee3};

        System.out.println(solution.compareArrays(employees1, employees2));
    }
}
