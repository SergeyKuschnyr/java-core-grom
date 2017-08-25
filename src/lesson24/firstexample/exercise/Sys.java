package lesson24.firstexample.exercise;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class Sys {
    private int filesCount;
    private String location;

    public Sys(int filesCount, String location) {
        this.filesCount = filesCount;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "filesCount=" + filesCount +
                ", location='" + location + '\'' +
                '}';
    }
}
