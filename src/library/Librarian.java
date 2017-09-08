package library;

/**
 * Created by Kushn_000 on 07.09.2017.
 */
public class Librarian {
    private String name;
    private String education;
    private int continuousService;
    private int startYear;

    public Librarian(String name, String education, int continuousService, int startYear) {
        this.name = name;
        this.education = education;
        this.continuousService = continuousService;
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public String getEducation() {
        return education;
    }

    public int getContinuousService() {
        return continuousService;
    }

    public int getStartYear() {
        return startYear;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "name='" + name + '\'' +
                ", education='" + education + '\'' +
                ", continuousService=" + continuousService +
                ", startYear=" + startYear +
                '}';
    }
}
