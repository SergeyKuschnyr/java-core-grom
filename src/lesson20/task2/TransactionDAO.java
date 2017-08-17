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
        transactions[validate(transaction)] = transaction;
        return transactions[validate(transaction)];
    }

    public Transaction[] transactionList() throws BadRequestException {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                count++;
            }
        }
        if (count == 0)
            throw new BadRequestException("Transactions list is empty");

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

    public Transaction[] transactionList(String city) throws BadRequestException {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCity().equals(city)) {
                count++;
            }
        }
        if (count == 0)
            throw new BadRequestException("Transaction is impossible for select city ");

        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getCity().equals(city)) {
                tr[count] = transaction;
                count++;
            }
        }
        return tr;
    }

    public Transaction[] transactionList(int amount) throws LimitExceeded {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getAmount() < amount) {
                count++;
            }
        }
        if (count == 0)
            throw new LimitExceeded("Amount limit exceeded");
        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions)
            if (transaction.getAmount() < amount) {
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

    private int validate(Transaction transaction) throws Exception {
        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed " + transaction.getId() + ". Can't be save");

        int sum = 0;
        int count = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            sum += tr.getAmount();
            count++;
        }

        if (sum > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() +
                    ". Can't be save");

        if (count > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() +
                    ". Can't be save");

        int count1 = 0;
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity())) {
                count1++;
                break;
            }
        }
        if (count1 == 0)
            throw new BadRequestException("Transaction forbid in selected city");

        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        throw new InternalServerException("Place not enough in server");
    }
}

