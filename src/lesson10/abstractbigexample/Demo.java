package lesson10.abstractbigexample;

/**
 * Created by Kushn_000 on 15.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
//////////////////////////////////////////////////////////////////////////////////
        String[] frameworks = {"qwerty", "asdfgh", "zxcvbn"};
        DeveloperEmployee developerEmployee = new DeveloperEmployee("Yan", 34, 3000,  frameworks);
        BankAccount bankAccount = new BankAccount(developerEmployee, 10000);

        developerEmployee.setBankAccount(bankAccount);

        System.out.println(developerEmployee.getBalance());
        developerEmployee.paySalary();
        System.out.println(developerEmployee.getBalance());
/////////////////////////////////////////////////////////////////////////////////////
        ManagerEmployee managerEmployee = new ManagerEmployee("Kolya", 23, 2000);
        BankAccount bankAccount2 = new BankAccount(managerEmployee, 6000);

        managerEmployee.setBankAccount(bankAccount2);

        System.out.println(managerEmployee.getBalance());
        managerEmployee.paySalary();
        System.out.println(managerEmployee.getBalance());
///////////////////////////////////////////////////////////////////////////////////////
        Employee[] employees = new Employee[10];
        employees[0] = developerEmployee;
        employees[1] = managerEmployee;
        EmployeeController employeeController = new EmployeeController(employees);
        employeeController.paySalaryToEmployees();

        System.out.println(developerEmployee.getBalance());
        System.out.println(managerEmployee.getBalance());
    }
}
