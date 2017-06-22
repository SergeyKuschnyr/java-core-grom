package lesson5;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 19.03.2017.
 */
public class ArraySort {
    public static void main(String[] args) {
        int[] testArray = {23, 6, 92, 44, -98, 567, 100};
        int[] testArray2 = {};
        int[] testArray3 = {0,0,0,0,0,0,0};
        System.out.println(Arrays.toString(sortAscending(testArray)));
        System.out.println(Arrays.toString(sortDescending(testArray)));

        System.out.println(Arrays.toString(sortAscending(testArray2)));
        System.out.println(Arrays.toString(sortDescending(testArray3)));

    }

    static int[] sortAscending(int[] array) {

        int[] ascendingArray = new int[array.length];

        for (int memberArr : array) {
            int numberOfMembers = 0;
            for (int memberArrLoop : array) {
                if (memberArrLoop < memberArr)
                    numberOfMembers++;
            }
            ascendingArray[numberOfMembers] = memberArr;
        }

        return ascendingArray;
    }

    static int[] sortDescending(int[] array){
        int[] descendingArray = new int[array.length];

        for (int memberArr : array) {
            int numberOfMembers = 0;
            for (int memberArrLoop : array) {
                if (memberArrLoop > memberArr)
                    numberOfMembers++;
            }
            descendingArray[numberOfMembers] = memberArr;
        }

        return descendingArray;
    }
}
