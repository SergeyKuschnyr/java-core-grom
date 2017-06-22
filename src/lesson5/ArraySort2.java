package lesson5;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 19.03.2017.
 */
public class ArraySort2 {
    public static void main(String[] args) {
        int[] testArray = {23, 6, 92, 44, -98, 567, 100};
        int[] testArray2= {};
        int[] testArray3= {0,0,0,0,0};
        System.out.println(Arrays.toString(sortAscending(testArray)));
        System.out.println(Arrays.toString(sortDescending(testArray)));
        System.out.println(Arrays.toString(sortAscending(testArray2)));
        System.out.println(Arrays.toString(sortDescending(testArray2)));
        System.out.println(Arrays.toString(sortAscending(testArray3)));
        System.out.println(Arrays.toString(sortDescending(testArray3)));
    }

    static int[] sortAscending(int[] array){
        for(int arrMember = 0; arrMember < array.length; arrMember++){
            for(int arrMem= 0; arrMem < array.length; arrMem++){
                if(array[arrMember] < array[arrMem]){
                    int temp = array[arrMember];
                    array[arrMember] = array[arrMem];
                    array[arrMem] = temp;
                }
            }
        }
        return  array;
    }

    static int[] sortDescending(int[] array){
        for(int arrMember = 0; arrMember < array.length; arrMember++){
            for(int arrMem = 0; arrMem < array.length; arrMem++){
                if(array[arrMember] > array[arrMem]){
                    int temp = array[arrMember];
                    array[arrMember] = array[arrMem];
                    array[arrMem] = temp;
                }
            }
        }
        return  array;
    }
}
