package lesson24.firstexample.exercise;

/**
 * Created by Kushn_000 on 25.08.2017.
 */
public class GeneralDAO <T>{
    @SuppressWarnings("Unchecked")
    private T[] array = (T[]) new Object[5];

    public T save(T t){
        int index = 0;
        for (T el : array){
            if (el == null){
                array[index] = t;
                return array[index];
            }
            index++;
        }
        return  null;
    }

    public T[] getAll(){
        return array;
    }
}
