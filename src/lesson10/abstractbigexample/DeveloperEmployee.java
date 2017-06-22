package lesson10.abstractbigexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public class DeveloperEmployee extends Employee {
    private String[] frameworks = new String[3];

    public DeveloperEmployee(String name, int age, int salaryPerMonth, String[] frameworks) {
        super(name, age, salaryPerMonth);
        this.frameworks = frameworks;
    }

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        getBankAccount().setBalance(newBalance);
    }
}
