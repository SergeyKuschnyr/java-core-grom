package lesson30.itFirm;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class Controller {
    private EmployeeDAO employeeDAO;
    private ProjectDAO projectDAO;

    public Controller(EmployeeDAO employeeDAO, ProjectDAO projectDAO) {
        this.employeeDAO = employeeDAO;
        this.projectDAO = projectDAO;
    }

    //- список сотрудников, работающих над заданным проектом
    public ArrayList employeesByProject(Project project){
        return employeeDAO.employeesByProject(project);
    }

    //  список проектов, в которых участвует заданный сотрудник
    public HashSet projectsByEmployee(Employee employee){
        return employeeDAO.projectsByEmployee(employee);
    }

    //  список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public ArrayList employeesByDepartmentWithoutProject(Department department){
        return employeeDAO.employeesByDepartmentWithoutProject(department);
    }
    //  список сотрудников, не участвующих ни в одном проекте
    public ArrayList employeesWithoutProject(){
        return employeeDAO.employeesWithoutProject();
    }

    //  список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public ArrayList employeesByTeamLead(Employee lead){
        return employeeDAO.employeesByTeamLead(lead);
    }

    //  список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public ArrayList teamLeadsByEmployee(Employee employee){
        return employeeDAO.teamLeadsByEmployee(employee);
    }

    //  список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public ArrayList employeesByProjectEmployee(Employee employee){
        return employeeDAO.employeesByProjectEmployee(employee);
    }
    //  список проектов, выполняемых для заданного заказчика
    public ArrayList projectsByCustomer(Customer customer){
        return projectDAO.projectsByCustomer(customer);
    }

    //  список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public ArrayList employeesByCustomerProjects(Customer customer){
        return employeeDAO.employeesByCustomerProjects(customer);
    }
}
