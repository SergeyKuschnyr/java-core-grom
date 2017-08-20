package lesson20.task2;

import lesson20.task2.Exception.BadRequestException;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kushn_000 on 16.08.2017.
 */
public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1234L, "Kiev", 30, "qwerty1",
                TransactionType.INCOME, new Date(2017, 8, 12));
        Transaction transaction2 = new Transaction(1235L, "Odessa", 10, "qwerty2",
                TransactionType.INCOME, new Date(2017, 4, 17));
        Transaction transaction3 = new Transaction(1236L, "Kiev", 40, "qwerty3",
                TransactionType.INCOME, new Date(2017, 3, 20));
        Transaction transaction4 = new Transaction(1237L, "Kiev", 40, "qwerty4",
                TransactionType.OUTCOME, new Date(2017, 3, 20));
        Transaction transaction5 = new Transaction(1238L, "Odessa", 10, "qwerty5",
                TransactionType.OUTCOME, new Date(2017, 3, 20));


        Controller controller = new Controller();

        try {
            controller.save(transaction1);
            controller.save(transaction2);
            controller.save(transaction3);
            controller.save(transaction4);
            controller.save(transaction5);
            System.out.println(Arrays.toString(controller.transactionList()));

//            controller.save(null);
//            controller.save(transaction3);
            System.out.println();

            System.out.println(Arrays.toString(controller.transactionList()));
//
//            for (Transaction transaction : controller.transactionList())
//                if (transaction != null)
//                    System.out.println("id: " + transaction.getId());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        try {
//            controller.save(transaction1);
//        } catch (Exception e) {
//            System.out.println("error: " + e.getMessage());
//        }
    }
}
