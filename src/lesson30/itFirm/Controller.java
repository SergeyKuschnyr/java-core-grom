package lesson30.itFirm;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class Controller {
    private EmployeeDAO employeeDAO;
    private ManagerDAO managerDAO;
    private ProjectDAO projectDAO;

    public Controller(EmployeeDAO employeeDAO, ManagerDAO managerDAO, ProjectDAO projectDAO) {
        this.employeeDAO = employeeDAO;
        this.managerDAO = managerDAO;
        this.projectDAO = projectDAO;
    }

    //////////////////////////////////////////////////////////////////////////
    //    - public HashSet employeesByProject(Project project) {  //- список сотрудников, работающих над заданным проектом
    public TreeSet employeesByProject(Project project){
        return employeeDAO.employeesByProject(project);
    }
//    - projectsByEmployee(Employee employee) список проектов, в которых участвует заданный сотрудник
    public TreeSet projectsByEmployee(Employee employee){
        return employeeDAO.projectsByEmployee(employee);
    }
//    - employeesByDepartmentWithoutProject() - список сотрудников из заданного отдела, не участвующих ни в одном проекте
    public TreeSet employeesByDepartmentWithoutProject(Department department){
        return employeeDAO.employeesByDepartmentWithoutProject(department);
    }
//    - employeesWithoutProject() - список сотрудников, не участвующих ни в одном проекте
    public TreeSet employeesWithoutProject(){
        return employeeDAO.employeesWithoutProject();
    }
//    - employeesByTeamLead(Employee lead) - список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
    public TreeSet employeesByTeamLead(Manager lead){
        return employeeDAO.employeesByTeamLead(lead);
    }
//    - teamLeadsByEmployee(Employee employee) - список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public TreeSet teamLeadsByEmployee(Employee employee){
        return managerDAO.teamLeadsByEmployee(employee);
    }
//    - employeesByProjectEmployee(Employee employee) - список сотрудников, участвующих в тех же проектах, что и заданный сотрудник
    public TreeSet employeesByProjectEmployee(Employee employee){
        return employeeDAO.employeesByProjectEmployee(employee);
    }
//    - projectsByCustomer(Customer customer) - список проектов, выполняемых для заданного заказчика
    public TreeSet projectsByCustomer(Customer customer){
        return projectDAO.projectsByCustomer(customer);
    }
//    - employeesByCustomerProjects(Customer customer) - список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
    public TreeSet employeesByCustomerProjects(Customer customer){
        return employeeDAO.employeesByCustomerProjects(customer);
    }
}
