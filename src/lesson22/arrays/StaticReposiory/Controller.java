package lesson22.arrays.StaticReposiory;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class Controller {
    private static TransactionDAO transactionDAO = new TransactionDAO();

    public static Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    public static Transaction[] transactionList() {
            return transactionDAO.transactionList();
    }

    public static Transaction[] transactionList(String city) {
        return transactionDAO.transactionList(city);
    }

    public static Transaction[] transactionList(int amount) {
        return transactionDAO.transactionList(amount);
    }
}
