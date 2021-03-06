package lesson22.arrays.StaticReposiory;

import lesson22.arrays.StaticReposiory.Exception.BadRequestException;
import lesson22.arrays.StaticReposiory.Exception.InternalServerException;
import lesson22.arrays.StaticReposiory.Exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class TransactionDAO {
    private static Transaction[] transactions = new Transaction[10];
    private static Utils utils = new Utils();

    public static Transaction save(Transaction transaction) throws Exception {
        if (transaction == null) {
            throw new BadRequestException("The attempt to save null exception");
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

    public static Transaction[] transactionList() {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                count++;
            }
        }
        if (count == 0)
            return new Transaction[0];

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

    public static Transaction[] transactionList(String city) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getCity().equals(city)) {
                count++;
            }
        }
        if (count == 0)
            return new Transaction[0];

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

    public static Transaction[] transactionList(int amount) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null && transaction.getAmount() == amount) {
                count++;
            }
        }
        if (count == 0)
            return new Transaction[0];

        Transaction[] tr = new Transaction[count];
        count = 0;
        for (Transaction transaction : transactions)
            if (transaction != null && transaction.getAmount() == amount) {
                tr[count] = transaction;
                count++;
            }
        return tr;
    }

    private static Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
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

    private static void validate(Transaction transaction) throws Exception {
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
        if (count + 1 > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed " + transaction.getId() +
                    ". Can't be save");
        }
        ////////////////////////    3
        if (sum + transaction.getAmount() > utils.getLimitTransactionsPerDayAmount()) {
            System.out.println(sum + transaction.getAmount());
            throw new LimitExceeded("Transaction limit per day amount exceed " + transaction.getId() +
                    ". Can't be save");
        }
        ////////////////////////    4
        if (!transactionToCityEnable(transaction)) {
            throw new BadRequestException("Transaction with id: " + transaction.getId() +
                    " forbid in selected city");
        }
    }

    private static int nullPositionSearch(Transaction transaction) throws InternalServerException {
        for (int i = 0; i < transactions.length; i++) {
            if (transactions[i] == null) {
                return i;
            }
        }
        throw new InternalServerException("Place not enough on server for transaction with id: " +
                transaction.getId());
    }

    private static boolean transactionToCityEnable(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (city.equals(transaction.getCity())) {
                return true;
            }
        }
        return false;
    }
}