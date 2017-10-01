package lesson30.bankSystem;

import java.util.Date;

/**
 * Created by Kushn_000 on 01.10.2017.
 */
public class Transaction implements Comparable<Transaction>{
    private int id;
    private Date dateCreated;
    private Date dateConfirmed;

    private TransactionType type;

    private int amount;

    private String discription;

    public Transaction(int id, Date dateCreate, Date dateConfirmed, TransactionType type, int amount, String discription) {
        this.id = id;
        this.dateCreated = dateCreate;
        this.dateConfirmed = dateConfirmed;
        this.type = type;
        this.amount = amount;
        this.discription = discription;
    }

    @Override
    public int compareTo(Transaction tr) {
        return tr.dateCreated.compareTo(this.dateCreated);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", dateConfirmed=" + dateConfirmed +
                ", type=" + type +
                ", amount=" + amount +
                ", discription='" + discription + '\'' +
                '}';
    }
}
