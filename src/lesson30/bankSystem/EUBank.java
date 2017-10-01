package lesson30.bankSystem;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class EUBank extends Bank {
    public EUBank(long id, String bankCountry, Currency currency, int numberOfEmployee, double avrSalOfEmployees, long rating, long totalCapital) {
        super(id, bankCountry, currency, numberOfEmployee, avrSalOfEmployees, rating, totalCapital);
    }

    @Override
    public int getLimitOfWithdrawal() {
        if (getCurrency() == Currency.USD)
            return 2000;
        return 2200;
    }

    @Override
    public int getLimitOfFunding() {
        if (getCurrency() == Currency.EUR)
            return 20000;
        return 10000;
    }

    @Override
    public double getMonthlyRate() {
        if (getCurrency() == Currency.EUR)
            return 0.01;
        else
            return 0.0;
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
                return 0.02;
            else
                return 0.04;
        }
    }
}
