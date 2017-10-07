package lesson30.itFirm;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 29.09.2017.
 */
public class Manager implements Comparable<Manager>{
    private String name;
    private TreeSet<Project> projects;

    public Manager(String name, TreeSet<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {
        return name;
    }

    public TreeSet<Project> getProjects() {
        return projects;
    }

    @Override
    public int compareTo(Manager mngr) {
        return this.getName().compareTo(mngr.getName());
    }
}
