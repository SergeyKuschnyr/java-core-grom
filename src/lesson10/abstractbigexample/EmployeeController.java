package lesson10.abstractbigexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public class EmployeeController {
    private Employee[] employees = new Employee[100];

    public EmployeeController(Employee[] employees) {
        this.employees = employees;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    void paySalaryToEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.paySalary();
                System.out.println("Salary was paid successfully to " + employee.getName() + "employee");
            }
        }
    }
}
