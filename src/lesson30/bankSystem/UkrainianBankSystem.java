package lesson30.bankSystem;

import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class UkrainianBankSystem implements BankSystem {

    private Set<Transaction> transactions = new TreeSet<>();

    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));

        createAndSaveTransaction(new Date(), TransactionType.WITHDRAWAL, amount, "qwed");

    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.FUNDING, amount, "qwedf");
    }

    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        // TODO check withdraw rules
        if (!checkWithdraw(fromUser, amount))
            return;
        // TODO check fund rules
        if (!checkFund(toUser, amount))
            return;
        // Currency
        if (toUser.getBank().currency != fromUser.getBank().currency)
            return;
        // TODO withdraw
        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        // TODO fund
        toUser.setBalance(toUser.getBalance() + amount);

        createAndSaveTransaction(new Date(), TransactionType.TRANSFER, amount, "qwedf21");

    }

    @Override
    public void paySalary(User user) {
        // TODO homework
        if (!checkFund(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());

        createAndSaveTransaction(new Date(), TransactionType.SALARY_INCOME, user.getSalary(), "qwedf98");

    }

    public void test(User[] user, int[] amount) {
        for (User userLoop : user)
            for (int amountLoop : amount) {
                withdraw(userLoop, amountLoop);
                print(userLoop);
                fund(userLoop, amountLoop);
                print(userLoop);
                paySalary(userLoop);
                print(userLoop);
            }

        for (int amountLoop : amount)
            for (int i = 0; i < user.length - 1; i++) {
                transferMoney(user[i], user[i + 1], amountLoop);
                print(user[i]);
                System.out.println("-----TRANSFERED----->");
                print(user[i + 1]);
            }
    }

    private void print(User user) {
        System.out.println("Name of Client of bank: " + user.getName() + "     balance: " + user.getBalance());
    }

    private void printFundErrorMsg(int amount, User user) {
        if (user != null)
            System.err.println("Can't fund money " + amount + " from user" + user.toString());
        System.out.println("Null user");
    }

    private void printWithdrawErrorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + " from user" + user.toString());
    }

    private boolean checkFund(User user, int amount) {
        if (user != null && user.getBank().getLimitOfFunding() > amount)
            return true;
        else
            printFundErrorMsg(amount, user);
        return false;
    }

    private boolean checkWithdraw(User user, int amount) {
        if (user != null)
            return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                    checkWithdrawLimits(user, amount, user.getBalance());
        return false;
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawErrorMsg(amount, user);
            return false;
        }
        return true;
    }

    private Transaction createAndSaveTransaction(Date dateCreate, TransactionType type, int amount, String descr){
        Random random = new Random();
        Transaction tr = new Transaction(random.nextInt(), dateCreate, null, type, amount, descr);
        transactions.add(tr);
        return tr;
    }

    public Set<Transaction> getTransactions(){
        return transactions;
    }
}
