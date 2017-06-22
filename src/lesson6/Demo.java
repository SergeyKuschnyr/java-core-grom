package lesson6;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kushn_000 on 10.06.2017.
 */
public class Demo {
    public static void main(String[] args) {
        // Order class

//        void confirmOrder()

        Order order = new Order(100, new Date() , false, new Date(), "Dnepr", "Ukraine", "Buy");
        Order order2 = new Order(1500, new Date() , false, new Date(), "Kiev", "Ukraine", "Sale");
        Order order3 = new Order(1500, new Date() , false, new Date(), "Kiev", "Ukraine", "sale");

        System.out.println("Confirmed: " + order.isConfirmed + "  " + "Date confirmed: " + order.dateConfirmed);
        order.confirmOrder();
        System.out.println("Confirmed: " + order.isConfirmed + "  " + "Date confirmed: " + order.dateConfirmed);
        order.confirmOrder();
        System.out.println("Confirmed: " + order.isConfirmed + "  " + "Date confirmed: " + order.dateConfirmed);

//        boolean checkPrice()

        System.out.println("Price: " + order.price + "  " + "Check Price: " + order.checkPrice());
        System.out.println("Price: " + order2.price + "  " + "Check Price: " + order2.checkPrice());

//        boolean isValidType()

        System.out.println("Type: " + order.type + "  " + "Value Type: " + order.isValidType());
        System.out.println("Type: " + order2.type + "  " + "Value Type: " + order2.isValidType());
        System.out.println("Type: " + order3.type + "  " + "Value Type: " + order3.isValidType());

        // RemoveDuplicatesTask_2 Class

//        public int[] sortAscending(int[] array)

        int[] array = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        int[] array2 = {};
        int[] array3 = new int[5];
        RemoveDuplicatesTask_2 removeDuplicatesTask_2 = new RemoveDuplicatesTask_2();

        System.out.println(Arrays.toString(array));
        removeDuplicatesTask_2.sortAscending(array);
        System.out.println(Arrays.toString(array));
        removeDuplicatesTask_2.sortAscending(array2);
        System.out.println(Arrays.toString(array2));
        removeDuplicatesTask_2.sortAscending(array3);
        System.out.println(Arrays.toString(array3));
//
//        public int quantityOfDuplicates(int[] array)

        int[] arrayRenew = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};

        System.out.println(Arrays.toString(arrayRenew));
        System.out.println(removeDuplicatesTask_2.quantityOfDuplicates(arrayRenew));
        System.out.println(removeDuplicatesTask_2.quantityOfDuplicates(array2));
        System.out.println(removeDuplicatesTask_2.quantityOfDuplicates(array3));
//
//        public int[] removeDuplicates(int[] array)

        int[] arrayRenew2 = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};

        System.out.println(Arrays.toString(arrayRenew2));
        System.out.println(Arrays.toString(removeDuplicatesTask_2.removeDuplicates(arrayRenew2)));
        System.out.println(Arrays.toString(removeDuplicatesTask_2.removeDuplicates(array2)));
        System.out.println(Arrays.toString(removeDuplicatesTask_2.removeDuplicates(array3)));

        // SecondLargestClass
        System.out.println("SecondLargestClass");

//        public int[] sortArray(int[] arr)

        int[] arrayRenew3 = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        SecondLargestClass secondLargestClass = new SecondLargestClass();

        System.out.println(Arrays.toString(arrayRenew3));
        System.out.println(Arrays.toString(secondLargestClass.sortArray(arrayRenew3)));
        System.out.println(Arrays.toString(secondLargestClass.sortArray(array2)));
        System.out.println(Arrays.toString(secondLargestClass.sortArray(array3)));
//
//        public int secondLargest(int[] array)

        int[] arrayRenew4 = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};

        System.out.println(Arrays.toString(arrayRenew4));
        System.out.println(secondLargestClass.secondLargest(arrayRenew4));
        System.out.println(secondLargestClass.secondLargest(array2));
        System.out.println(secondLargestClass.secondLargest(array3));

    }
}
