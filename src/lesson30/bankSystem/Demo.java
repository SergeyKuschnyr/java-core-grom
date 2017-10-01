package lesson30.bankSystem;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception{
        Bank USBank = new USBank(1222, "USA", Currency.USD, 100, 1400, 4, 44444488);
        User userOfUSBank1 = new User(1001, "Denis", 12200, 40, "Apple", 5000, USBank);
        User userOfUSBank2 = new User(1002, "John", 15000, 30, "IBM", 4000, USBank);

        Bank EUBank = new EUBank(1022, "Spain", Currency.EUR, 150, 1400, 4, 44445588);
        User userOfEUBank1 = new User(1201, "Domingo", 8200, 50, "Bosch", 3000, EUBank);
        User userOfEUBank2 = new User(1202, "Salvador", 9000, 20, "BMW", 4000, EUBank);

        Bank ChinaBank = new ChinaBank(1522, "China", Currency.USD, 700, 1400, 4, 44446688);
        User userOfChinaBank1 = new User(1071, "Mao", 2200, 40, "Alibaba", 500, ChinaBank);
        User userOfChinaBank2 = new User(1072, "Chia", 1500, 50, "AirCnina", 1000, ChinaBank);

        User[] userArr = {userOfUSBank1, userOfUSBank2, userOfEUBank1, userOfEUBank2, userOfChinaBank1, userOfChinaBank2};

        int[] amountArr = {50, 100, 500, 1000, 10000};

        UkrainianBankSystem ukrainianBankSystem = new UkrainianBankSystem();

        //ukrainianBankSystem.test(userArr, amountArr);

        ukrainianBankSystem.withdraw(userOfChinaBank1, 10);
        Thread.sleep(2000);
        ukrainianBankSystem.withdraw(userOfChinaBank1, 30);
        System.out.println(ukrainianBankSystem.getTransactions());
        System.out.println();

        ukrainianBankSystem.fund(userOfEUBank1, 10);
        Thread.sleep(2000);
        ukrainianBankSystem.fund(userOfEUBank2, 20);
        System.out.println(ukrainianBankSystem.getTransactions());
        System.out.println();

        Thread.sleep(2000);
        ukrainianBankSystem.transferMoney(userOfUSBank1, userOfUSBank2, 40);
        Thread.sleep(2000);
        ukrainianBankSystem.transferMoney(userOfUSBank2, userOfUSBank1, 70);
        System.out.println(ukrainianBankSystem.getTransactions());

    }
}
