package lesson20.task2;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class Utils {
    private int limitTransactionsPerDayCount = 10;
    private int limitTransactionPerDayAmount = 100;
    private int limitSimpleTransactionAmount = 40;
    private String[] cities = {"Kiev", "Odessa"};

    public int getLimitTransactionsPerDayCount() {
        return limitTransactionsPerDayCount;
    }

    public int getLimitTransactionPerDayAmount() {
        return limitTransactionPerDayAmount;
    }

    public int getLimitSimpleTransactionAmount() {
        return limitSimpleTransactionAmount;
    }

    public String[] getCities() {
        return cities;
    }
}
