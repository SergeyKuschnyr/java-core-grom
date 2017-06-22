package lesson6;

/**
 * Created by Kushn_000 on 29.03.2017.
 */
public class RemoveDuplicatesTask_2 {
   /* public static void main(String[] args) {
        int[] array = {1, 11, 12, 0, -2, 11, 0, -2, 35, 99, 9, 10, 1};
        // int[] emptyArr = {};
        for (int e = 0; e < array.length; e++)
            System.out.print(array[e] + ", ");
        System.out.println();
        for (int i = 0; i < removeDuplicates(array).length; i++)
            System.out.print(removeDuplicates(array)[i] + ", ");
    }*/

    public RemoveDuplicatesTask_2() {
    }

    public int[] sortAscending(int[] array) {
        for (int q = 0; q < array.length; q++)
            for (int w = 0; w < array.length; w++)
                if (array[q] < array[w]) {
                    int temp = array[q];
                    array[q] = array[w];
                    array[w] = temp;
                }
        return array;
    }

    public int quantityOfDuplicates(int[] array) {
        int[] temp = sortAscending(array);
        int index = 0;
        int counter = 0;
        for (int r = index; r < (temp.length - 1); r++) {
            if (temp[r] == temp[r + 1])
                counter++;
            index = temp[r + 1];
        }
        return counter;
    }

    public int[] removeDuplicates(int[] array) {
        if (array.length == 0)
            return array;
        int[] retArr = new int[sortAscending(array).length - quantityOfDuplicates(array)];
        int index = 0;
        for (int t = 0; t < (array.length - 1); t++) {
            if (array[t] != array[t + 1]) {
                retArr[index] = array[t];
                index++;
            }
        }
        retArr[retArr.length - 1] = array[array.length - 1];
        return retArr;
    }
}
