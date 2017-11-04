package compareArray;

import java.util.Map;

/**
 * Created by Kushn_000 on 04.11.2017.
 */
public class Solution {
    public boolean compareIntArrays(int[] first, int[] second){
        if (first.length != second.length){
            return false;
        }
        for (int i = 0; i < first.length; i++){
            if(first[i] != second[i]){
                return false;
            }
        }
        return true;
    }
    public boolean compareStringArrays(String[] first, String[] second){
        if (first.length != second.length){
            return false;
        }
        for (int i = 0; i < first.length; i++){
            if(!first[i].equals(second[i])){
                return false;
            }
        }
        return true;
    }
    public <T> boolean compareArrays(T[] first, T[] second) {
        if (first.length != second.length){
            return false;
        }
        for (int i = 0; i < first.length; i++){
            if(!first[i].equals(second[i])){
                return false;
            }
        }
        return true;
    }
}