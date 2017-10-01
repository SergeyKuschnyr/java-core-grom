package lesson30.bankSystem;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public interface BankSystem {
    void withdraw(User user, int amount);
    void fund(User user, int amount);
    void transferMoney(User fromUser, User toUser, int amount);
    void paySalary(User user);
}
