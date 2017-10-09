package lesson30.itFirm;

import java.util.TreeSet;

/**
 * Created by Kushn_000 on 02.10.2017.
 */
public class ProjectDAO {
    private TreeSet<Project> projects;

    public ProjectDAO(TreeSet<Project> projects) {
        this.projects = projects;
    }

    // список проектов, выполняемых для заданного заказчика
    public TreeSet projectsByCustomer(Customer customer){
        TreeSet<Project> tempPrj = new TreeSet<>();
        for (Project project : projects){
            if (project.getCustomer().equals(customer)){
                tempPrj.add(project);
            }
        }
        return tempPrj;
    }

}
