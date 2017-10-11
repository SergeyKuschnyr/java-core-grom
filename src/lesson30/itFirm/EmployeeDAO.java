package lesson30.itFirm;

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

    // список сотрудников, работающих над заданным проектом
    public TreeSet employeesByProject(Project project) {
        TreeSet<Employee> outProject = new TreeSet<>();
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
    public TreeSet projectsByEmployee(Employee employee) {
        TreeSet<Project> projects = new TreeSet<>();
        if (employee == null) {
            return projects;
        }
        return employee.getProjects();
    }

    //список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public TreeSet employeesByDepartmentWithoutProject(Department department) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
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
    public TreeSet employeesWithoutProject() {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        for (Employee employee : employees) {
            if (employee.getProjects().size() == 0) {
                tempEmpl.add(employee);
            }
        }
        return tempEmpl;
    }

    // список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public TreeSet employeesByTeamLead(Employee lead) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        if (lead == null) {
            return tempEmpl;
        }
        if (lead.getPosition() != Position.TEAM_LEAD) {
            return tempEmpl;
        }
        for (Employee employee : employees) {
            if (employee.getPosition() != Position.TEAM_LEAD) {
                if (isEqualsProject(employee, lead)){
                    tempEmpl.add(employee);
                }
            }
        }
        return tempEmpl;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public TreeSet teamLeadsByEmployee(Employee employee) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        if (employee == null) {
            return tempEmpl;
        }
        if (employee.getPosition() == Position.TEAM_LEAD) {
            return tempEmpl;
        }
        for (Employee employee1 : employees) {
            if (employee1.getPosition() == Position.TEAM_LEAD) {
                if (isEqualsProject(employee1, employee)){
                    tempEmpl.add(employee1);
                }
            }
        }
        return tempEmpl;
    }

    // список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public TreeSet employeesByProjectEmployee(Employee empl) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
        if (empl == null) {
            return tempEmpl;
        }
        for (Employee employee : employees) {
            if (isEqualsProject(employee, empl)){
                tempEmpl.add(employee);
            }
        }
        return tempEmpl;
    }

    //  список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public TreeSet employeesByCustomerProjects(Customer customer) {
        TreeSet<Employee> tempEmpl = new TreeSet<>();
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

    private Boolean isEqualsProject(Employee employee1, Employee employee2) {
        for (Project project : employee1.getProjects()) {
            for (Project project1 : employee2.getProjects()) {
                if (project.equals(project1)) {
                    return true;
                }
            }
        }
        return false;
    }
}


//                for (Project project : employee.getProjects()) {
//                    for (Project project1 : lead.getProjects()) {
//                        if (project.equals(project1)) {
//                            tempEmpl.add(employee);
//                        }
//                    }
//                }