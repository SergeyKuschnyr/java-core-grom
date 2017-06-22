package lesson11.biginterfaceexample;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class FileReader implements Readable {
    // CHECK THIS METHOD
    @Override
    public void readFilesForStorage(Storage storage) {
        printFile(findMaxSizeFile(storage.getFiles()));
    }

    private File findMaxSizeFile(File[] files){
        File maxFileSize = files[0];

        for (File file : files){
            if (file != null && file.getSize() > maxFileSize.getSize())
                maxFileSize = file;
        }
        return maxFileSize;
    }

    private void printFile(File file){
        System.out.println("max file will be printed now....");
        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
        System.out.println();
    }
}
