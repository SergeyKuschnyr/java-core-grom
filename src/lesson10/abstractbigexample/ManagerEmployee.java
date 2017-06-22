package lesson10.abstractbigexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public class ManagerEmployee extends Employee {

    public ManagerEmployee(String name, int age, int salaryPerMonth) {
        super(name, age, salaryPerMonth);
    }

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth();
        newBalance += newBalance * 0.25;
        getBankAccount().setBalance(newBalance);
    }
}
