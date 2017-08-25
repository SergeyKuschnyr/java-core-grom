package lesson24.firstexample.exercise;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class Tool {
    private String name;
    private String description;

    public Tool(String first, String second) {
        this.name = first;
        this.description = second;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
