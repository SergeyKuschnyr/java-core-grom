package lesson10.polyexample;

/**
 * Created by Kushn_000 on 20.04.2017.
 */
public class Child extends Human {

    public Child(String name) {
        super(name);
    }

    @Override
    void run() {
        System.out.println("Child lass called...");
        super.run();
    }
}