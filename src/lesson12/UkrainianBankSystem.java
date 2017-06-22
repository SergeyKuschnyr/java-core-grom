package lesson12;

/**
 * Created by Kushn_000 on 09.05.2017.
 */
public class UkrainianBankSystem implements BankSystem {
    @Override
    public void withdraw(User user, int amount) {

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - amount * user.getBank().getCommission(amount));
    }

    @Override
    public void fund(User user, int amount) {
        if (!checkFund(user, amount))
            return;
        user.setBalance(user.getBalance() + amount);
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
    }

    @Override
    public void paySalary(User user) {
        // TODO homework
        if (!checkFund(user, user.getSalary()))
            return;
        user.setBalance(user.getBalance() + user.getSalary());
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
}
