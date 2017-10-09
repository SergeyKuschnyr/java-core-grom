package lesson30.itFirm;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class EmployeeDAO {
    private TreeSet<Employee> employees;

    public EmployeeDAO(TreeSet employees) {
        this.employees = employees;
    }

    public EmployeeDAO() {
    }

    public TreeSet<Employee> getEmployees() {
        return employees;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // список сотрудников, работающих над заданным проектом
    public TreeSet employeesByProject(Project project) {
        TreeSet<Employee> outProject = new TreeSet<>();
        for (Employee employee : employees) {
            for (Project project1 : employee.getProjects()) {
                if (project1.equals(project)) {
                    outProject.add(employee);
                }
            }
        }
        return outProject;
    }

    // список проектов, в которых участвует заданный сотрудник
    public TreeSet projectsByEmployee(Employee employee) {  //список проектов, в которых участвует заданный сотрудник
        return employee.getProjects();
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public TreeSet employeesByDepartmentWithoutProject(Department department) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                if (employee.getProjects().size() == 0) {
                    tempEmpl.add(employee);
                }
            }
        }
        return tempEmpl;
    }

    // список сотрудников, не участвующих ни в одном проекте
    public TreeSet employeesWithoutProject() {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project != null) {
                    break;
                }
            }
            tempEmpl.add(employee);
        }
        return tempEmpl;
    }

    // список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public TreeSet employeesByTeamLead(Manager lead) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                for (Project project1 : lead.getProjects()) {
                    if (project.equals(project1)) {
                        System.out.println("TEST");

                        tempEmpl.add(employee);
                    }
                }
            }
        }
        return tempEmpl;
    }

    // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public TreeSet employeesByProjectEmployee(Employee empl) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                for (Project project1 : empl.getProjects()) {
                    if (project.equals(project1)) {
                        tempEmpl.add(employee);
                    }
                }
            }
        }
        return tempEmpl;
    }

    //  список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public TreeSet employeesByCustomerProjects(Customer customer) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer().equals(customer)) {
                    tempEmpl.add(employee);
                }
            }
        }
        return tempEmpl;
    }

}
