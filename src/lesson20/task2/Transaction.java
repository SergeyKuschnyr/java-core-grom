package lesson20.task2;

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
    private Date dateCreate;

    public Transaction(long id, String city, int amount, String description, TransactionType type, Date dateCreate) {
        this.id = id;
        this.city = city;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.dateCreate = dateCreate;
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

    public Date getDateCreate() {
        return dateCreate;
    }
}
