package lesson10.polyexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public class User extends Human {

    public User(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("User lass called...");
        super.run();
    }
}
