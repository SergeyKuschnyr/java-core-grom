package lesson24.firstexample;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class User {
    private int age;

    public User(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                '}';
    }
}
