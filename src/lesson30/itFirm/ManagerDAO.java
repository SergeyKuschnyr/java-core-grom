package lesson30.itFirm;

import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class ManagerDAO {
    public TreeSet<Manager> managers;

    public ManagerDAO(TreeSet<Manager> managers) {
        this.managers = managers;
    }

    //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)
    public TreeSet teamLeadsByEmployee(Employee employee){
        TreeSet<Manager> tempEmpl = new TreeSet<>();
        for (Manager manager : managers){
            for (Project project : manager.getProjects()){
                for (Project project1 : employee.getProjects()){
                    if (project.equals(project1)){
                        tempEmpl.add(manager);
                    }
                }
            }
        }
        return tempEmpl;
    }
}
