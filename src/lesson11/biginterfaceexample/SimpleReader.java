package lesson11.biginterfaceexample;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class SimpleReader implements Readable {
    @Override
    public void readFilesForStorage(Storage storage) {
        for (File file : storage.getFiles()) {
            if (file != null)
                System.out.println(file.getName());
            else
                System.out.println(file);
        }
    }
}
