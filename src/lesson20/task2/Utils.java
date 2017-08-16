package lesson20.task2;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class Utils {
    private int liminTransactionPerDayCount = 10;
    private int liminTransactionPerDayAmount = 100;
    private int limitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionPerDayCount() {
        return liminTransactionPerDayCount;
    }

    public int getLimitTransactionPerDayAmount() {
        return liminTransactionPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
