package lesson6;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 31.03.2017.
 */
public class SecondLargestClass {
   /* public static void main(String[] args) {
        int[] array = {99, 35, 1, 11, 12, 0, -2, 11, 0, -2, 9, 10, 1};
        int[] array2 = {678, 150, 19, 65, 9, 45, 1, 12, -67, 43, 1, 1, -23, 88};
        int[] array3 = {12, 34};
        int[] array4 = {78};

        // System.out.println(Arrays.toString(sortArray(array4)));

        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sortArray(array)));
        System.out.println(secondLargest(array));

        System.out.println(Arrays.toString(array2));
        System.out.println(secondLargest(array2));

        System.out.println(Arrays.toString(array3));
        System.out.println(secondLargest(array3));

        System.out.println(Arrays.toString(array4));
        System.out.println(secondLargest(array4));

        // System.out.println();
        // System.out.println(Arrays.toString(arrGenerator()));
        // System.out.println(secondLargest(arrGenerator()));
    }*/

    public SecondLargestClass() {
    }

    public int[] sortArray(int[] arr) {
        int n = arr.length;
        int temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] < arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return arr;
    }

    public int secondLargest(int[] array) {
        if (array.length != 0) {
            int secondMaxEl = sortArray(array)[0];
            for (int el : array) {
                if (el != secondMaxEl) {
                    secondMaxEl = el;
                    break;
                }
            }
            if (array[0] != secondMaxEl)
                return secondMaxEl;
            System.out.print("0 array: ");
            return 0;
        }
        System.out.print("Empty array: ");
        return 0;
    }
}
//    static int secondLargest(int[] array) {
//        if (array.length < 2)
//            return 0;
//        for (int i = 0; i < (array.length - 1); i++)
//            if (array[i] != array[i + 1])
//                break;
//            else
//                return 0;
//        int sLargest = sortArray(array)[0];
//        for (int i = 0; i < sortArray(array).length; i++) {
//            if (sortArray(array)[i] > sortArray(array)[i + 1])
//                sLargest = sortArray(array)[i + 1];
//            break;
//        }
//        return sLargest;
//    }


/*int[] tempArr = sortArray(array);
        int maxMember = tempArr[0];
        int sLargest = tempArr[0];
        System.out.println(Arrays.toString(tempArr));
        for (int arrMember = 0; arrMember < tempArr.length; arrMember++)
            if (tempArr[arrMember] < maxMember) {
                sLargest = maxMember;
                maxMember = tempArr[arrMember];
                System.out.println(sLargest);
                System.out.println(maxMember);
            }*/
