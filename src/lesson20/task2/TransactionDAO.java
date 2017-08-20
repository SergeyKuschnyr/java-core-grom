package lesson20.task2;

import lesson20.task2.Exception.BadRequestException;
import lesson20.task2.Exception.InternalServerException;
import lesson20.task2.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) {
            return null;
        }

        for (Transaction tr : transactions) {
            if (tr != null && tr.equals(transaction)) {
                throw new BadRequestException("Transaction with id: " + transaction.getId() + " already exist");
            }
        }

        validate(transaction);

        int index = nullPositionSearch(transaction);

        transactions[index] = transaction;
        return transactions[index];
    }

    public Transaction[] transactionList() {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                count++;
            }
        }
        if (count == 0)
            return null;

        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                tr[count] = transaction;
                count++;
            }
        }
        return tr;
    }

    public Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                count++;
            }
        }
        if (count == 0)
            return null;

        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                tr[count] = transaction;
                count++;
            }
        }
        return tr;
    }

    public Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() < amount) {
                count++;
            }
        }
        if (count == 0)
            return null;

        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions)
            if (transaction != null && transaction.getAmount() < amount) {
                tr[count] = transaction;
                count++;
            }
        return tr;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);

        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }

        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private void validate(Transaction transaction) throws Exception {
        //////////////////////////  1
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be save");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }
        /////////////////////////   2
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() +
                    ". Can't be save");
        }
        ////////////////////////    3
        if (count + 1 > utils.getLimitTransactionsPerDayCount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() +
                    ". Can't be save");
        ////////////////////////    4
        if (!transactionToCityEnable(transaction)){
            throw new BadRequestException("Transaction with id: " + transaction.getId() +
                    " forbid in selected city");
        }
    }

    private int nullPositionSearch(Transaction transaction) throws InternalServerException {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        throw new InternalServerException("Place not enough on server for transaction with id: " +
                transaction.getId());
    }

    private boolean transactionToCityEnable(Transaction transaction) throws BadRequestException{
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity())) {
                return true;
            }
        }
        return false;
    }
}