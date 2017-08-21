package lesson20.task2;

import lesson20.task2.Exception.BadRequestException;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save(Transaction transaction) throws Exception {
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList() {
            return transactionDAO.transactionList();
    }

    public Transaction[] transactionList(String city) {
        return transactionDAO.transactionList(city);
    }

    public Transaction[] transactionList(int amount) {
        return transactionDAO.transactionList(amount);
    }
}
