package lesson20.task2;

import lesson20.task2.Exception.BadRequestException;
import lesson20.task2.Exception.LimitExceeded;

import java.util.Date;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class Transaction {
    private long id;
    private String city;
    private int amount;
    private String description;
    private TransactionType type;
    private Date dateCreated;
    private Utils utils = new Utils();

    public Transaction(long id, String city, int amount, String description, TransactionType type,
                       Date dateCreated) throws BadRequestException{
        this.id = id;
        int index = 0;
        for (String curCity : utils.getCities())
            if (curCity.equals(city)) {
                this.city = city;
                index++;
            }
        if (index == 0)
            throw new BadRequestException("Transactions is impossible in selected city");

        if (utils.getLimitSimpleTransactionAmount() < amount)
            throw new LimitExceeded("Transaction amount exceed");
        this.amount = amount;

        this.description = description;
        this.type = type;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
