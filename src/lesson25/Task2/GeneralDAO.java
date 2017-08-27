package lesson25.Task2;

import lesson25.task1.IdEntity;
import lesson25.task1.Order;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class GeneralDAO<T> {
    //private T t;
    private T[] arrT;

    public GeneralDAO() {
        //this.t = t;
        this.arrT = (T[]) new Object[10];
    }

    public T[] getArrT() {
        return arrT;
    }

//    public T getT() {
//        return t;
//    }

    public T save(T t) throws Exception {
        if (t == null) {
            throw new Exception("The attempt to save null exception");
        }

        for (T t1 : arrT) {
            if (t1 != null && t1.equals(t)) {
                throw new Exception("Transaction with id: " + t.toString() + " already exist");
            }
        }

        int index = nullPositionSearch(arrT);

        arrT[index] = t;
        return arrT[index];
    }

    public T[] getAll(T[] t) throws Exception{
        if (t == null){
            return (T[]) new Object[0];
        }
        int count = 0;
        for (T t1 : t){
            if (t1 != null){
                count++;
            }
        }
        if (count == 0){
            throw new Exception("List is empty");
        }

        T[] exitArr = (T[]) new Object[count];
        count = 0;
        for (T t1 : t){
            if (t1 != null){
                exitArr[count] = t1;
                count++;
            }
        }
        return exitArr;
    }

    private int nullPositionSearch(T[] arrT) throws Exception {
        for (int i = 0; i < arrT.length; i++) {
            if (arrT[i] == null) {
                return i;
            }
        }
        throw new Exception("Place not enough on server");
    }

//    @Override
//    public String toString() {
//        return "GeneralDAO{" +
//                "t=" + t +
//                '}';
//    }
}
