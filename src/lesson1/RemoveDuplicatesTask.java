package lesson1;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 25.03.2017.
 */
public class RemoveDuplicatesTask {
    public static void main(String[] args) {
        // int[] array = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        int[] array = {};
        /*for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + "  ");
        System.out.println();*/
        for (int j = 0; j < removeDuplicates(array).length; j++)
            System.out.print(removeDuplicates(array)[j] + "  ");

    }

    static int[] removeDuplicates(int[] array) {
        if (array.length != 0){
        int[] tempArr = new int[array.length - quantityOfDuplicates(array) + 1];
        for (int t = 0; t < tempArr.length; t++)
            tempArr[t] = array[t];
        return sortAscending(tempArr);
        }
        return array;
    }

    static int quantityOfDuplicates(int[] array) {
        int counter = 0;
        for (int q = 0; q < array.length; q++)
            for (int w = 0; w < array.length; w++)
                if (q != w)
                    if (array[q] == array[w])
                        for (int e = w; e < (array.length - 1); e++)
                            array[e] = array[e + 1];
        for (int r = 0; r < array.length; r++)
            if (array[r] == array[array.length - 1])
                counter++;
        return counter;
    }

    static int[] sortAscending(int[] array) {
        for (int arrMember = 0; arrMember < array.length; arrMember++) {
            for (int arrMem = (arrMember + 1); arrMem < array.length; arrMem++) {
                if (array[arrMember] > array[arrMem]) {
                    int temp = array[arrMember];
                    array[arrMember] = array[arrMem];
                    array[arrMem] = temp;
                }
            }
        }
        return array;
    }
}


