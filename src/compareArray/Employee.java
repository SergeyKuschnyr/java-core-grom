package compareArray;

/**
 * Created by Kushn_000 on 04.11.2017.
 */
public class Employee {
    private int age;
    private String name;
    private double Salary;

    public Employee(int age, String name, double salary) {
        this.age = age;
        this.name = name;
        Salary = salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return Salary;
    }
}
