package lesson30.bankSystem;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class ChinaBank extends Bank {
    public ChinaBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 100;
        return 150;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR)
            return 5000;
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.USD)
            return 0.01;
        else
            return 0.0;
    }

    @Override
    public double getCommission(int amout) {
        if (getCurrency() == Currency.USD) {
            if (amout <= 1000)
                return 0.03;
            else
                return 0.05;
        } else {
            if (amout <= 1000)
                return 0.1;
            else
                return 0.11;
        }
    }
}
