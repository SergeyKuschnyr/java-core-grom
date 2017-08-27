package lesson25.Task2;

/**
 * Created by Kushn_000 on 27.08.2017.
 */
public class Car {
    private int currentSpeed;
    private int maxSpeed;
    private String engineType;

    public Car(int currentSpeed, int maxSpeed, String engineType) {
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        this.engineType = engineType;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public String getEngineType() {
        return engineType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "currentSpeed=" + currentSpeed +
                ", maxSpeed=" + maxSpeed +
                ", engineType='" + engineType + '\'' +
                '}';
    }
}
