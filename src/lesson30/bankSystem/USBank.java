package lesson30.bankSystem;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class USBank extends Bank {
    public USBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 1000;
        return 1200;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR)
            return 10000;
        return Integer.MAX_VALUE;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.EUR)
            return 0.02;
        else
            return 0.01;
    }

    @Override
    public double getCommission(int amout) {
        if (getCurrency() == Currency.USD) {
            if (amout <= 1000)
                return 0.05;
            else
                return 0.07;
        } else {
            if (amout <= 1000)
                return 0.06;
            else
                return 0.08;
        }
    }
}
