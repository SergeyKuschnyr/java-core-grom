package lesson30.itFirm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class EmployeeDAO {
    private HashSet<Employee> employees;

    public EmployeeDAO(HashSet employees) {
        this.employees = employees;
    }

    public EmployeeDAO() {
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    // список сотрудников, работающих над заданным проектом
    public ArrayList employeesByProject(Project project) {
        ArrayList<Employee> outProject = new ArrayList<>();
        if (project == null) {
            return outProject;
        }
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
    public HashSet projectsByEmployee(Employee employee) {
        HashSet<Project> projects = new HashSet<>();
        if (employee == null) {
            return projects;
        }
        return employee.getProjects();
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public ArrayList employeesByDepartmentWithoutProject(Department department) {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        if (department == null) {
            return tempEmpl;
        }
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
    public ArrayList employeesWithoutProject() {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getProjects().size() == 0) {
                tempEmpl.add(employee);
            }
        }
        return tempEmpl;
    }

    // список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public ArrayList employeesByTeamLead(Employee lead) {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        if (lead == null) {
            return tempEmpl;
        }
        if (lead.getPosition() != Position.TEAM_LEAD) {
            return tempEmpl;
        }
        for (Employee employee : employees) {
            if (employee.getPosition() != Position.TEAM_LEAD) {
                isEqualsProjects(employee, lead, tempEmpl);
            }
        }
        return tempEmpl;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public ArrayList teamLeadsByEmployee(Employee employee) {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        if (employee == null) {
            return tempEmpl;
        }
        if (employee.getPosition() == Position.TEAM_LEAD) {
            return tempEmpl;
        }
        for (Employee employee1 : employees) {
            if (employee1.getPosition() == Position.TEAM_LEAD) {
                isEqualsProjects(employee1, employee, tempEmpl);
            }
        }
        return tempEmpl;
    }

    // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public ArrayList employeesByProjectEmployee(Employee empl) {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        if (empl == null) {
            return tempEmpl;
        }
        for (Employee employee : employees) {
            isEqualsProjects(employee, empl, tempEmpl);
        }
        return tempEmpl;
    }

    //  список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public ArrayList employeesByCustomerProjects(Customer customer) {
        ArrayList<Employee> tempEmpl = new ArrayList<>();
        if (customer == null) {
            return tempEmpl;
        }
        for (Employee employee : employees) {
            for (Project project : employee.getProjects()) {
                if (project.getCustomer().equals(customer)) {
                    tempEmpl.add(employee);
                }
            }
        }
        return tempEmpl;
    }

    private ArrayList isEqualsProjects(Employee employee1, Employee employee2, ArrayList ts) {
        for (Project project : employee1.getProjects()) {
            for (Project project1 : employee2.getProjects()) {
                if (project.equals(project1)) {
                    ts.add(employee1);
                }
            }
        }
        return ts;
    }
}


//                for (Project project : employee.getProjects()) {
//                    for (Project project1 : lead.getProjects()) {
//                        if (project.equals(project1)) {
//                            tempEmpl.add(employee);
//                        }
//                    }
//                }