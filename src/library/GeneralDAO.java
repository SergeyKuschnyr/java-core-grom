package library;

import lesson15.HW.userRepository.User;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 08.09.2017.
 */
public class GeneralDAO<T> {
    private T[] ts;
    private T[] tsOut;

    public GeneralDAO() {
        this.ts = (T[]) new Object[10];
        this.tsOut = (T[]) new Object[10];
    }

    //add/////////////////////////////////////////////////////////////////////////////
    public T add(T t) throws Exception {
        if (t == null) {
            return null;
        }
        int index = emptyPlace();
        ts[index] = t;
        System.out.println("Item added successfully");
        return ts[index];
    }

    //issue
    public T issue(T t, Users user) {
        if (user == Users.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        if (t == null)
            return null;
        T tTemp = bookMove(ts, tsOut, t);
        System.out.println("Book issued successfully");
        return tTemp;
    }

    //return
    public T returnBook(T t, Users user) {
        if (user == Users.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        if (t == null)
            return null;
        T tTemp = bookMove(tsOut, ts, t);
        System.out.println("Book returned successfully");
        return tTemp;
    }

    //view
    public T[] getAll() {
        return noNullItem(ts);
    }

    //view issued book
    public T[] getIssuedBooks(Users user) {
        if (user == Users.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        return noNullItem(tsOut);
    }

    //del
    public T del(T t, Users user) throws Exception {
        if (user == Users.LIBRARIAN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        if (t == null)
            return null;
        int index = 0;
        for (T t1 : ts) {
            if (t1.equals(t)) {
                ts[index] = null;
                System.out.println("Record deleted successfully");
                index++;
                break;
            }
            index++;
        }
        if (index == 0)
            throw new Exception("Selected librarian no exist");
        return t;
    }

    //////////////////////////////////////////////////////////////////////////////
    private T bookMove(T[] ts1, T[] ts2, T t) {
        if (t == null)
            return null;
        int index = 0;
        for (T t1 : ts1) {
            if (t1 != null && t1.equals(t)) {
                index++;
                break;
            }
            index++;
        }
        if ((index) == 0)
            return null;
        int index2 = 0;
        for (T t1 : ts2) {
            if (t1 == null) {
                ts1[index - 1] = null;
                ts2[index2] = t;
                break;
            }
            index2++;
        }
        return ts2[index2];
    }

    private int emptyPlace() throws Exception {
        int index = 0;
        for (T t : ts) {
            if (t == null) {
                index++;
                break;
            }
            index++;
        }
        if (index == 0)
            throw new Exception("No empty place");
        return (index - 1);
    }

    private T[] noNullItem(T[] ts) {
        if (ts == null || ts.length == 0)
            return (T[]) new Object[0];
        int index = 0;
        for (T t : ts)
            if (t != null)
                index++;
        if (index == 0)
            return (T[]) new Object[0];
        T[] outArray = (T[]) new Object[index];
        index = 0;
        for (T t : ts)
            if (t != null) {
                outArray[index] = t;
                index++;
            }
        return outArray;
    }

    @Override
    public String toString() {
        return "GeneralDAO{" +
                "ts=" + Arrays.toString(ts) +
                ", tsOut=" + Arrays.toString(tsOut) +
                '}';
    }
}
