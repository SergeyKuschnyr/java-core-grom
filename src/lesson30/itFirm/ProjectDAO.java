package lesson30.itFirm;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class ProjectDAO {
    private TreeSet<Project> projects;

    public ProjectDAO(TreeSet<Project> projects) {
        this.projects = projects;
    }

    public ProjectDAO() {
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    public TreeSet projectsByCustomer(Customer customer){  // список проектов, выполняемых для заданного заказчика
        TreeSet<Project> tempPrj = new TreeSet<>();
        for (Project project : projects){
            if (project.getCustomer().equals(customer)){
                tempPrj.add(project);
            }
        }
        return tempPrj;
    }

}
