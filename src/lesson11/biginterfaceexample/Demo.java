package lesson11.biginterfaceexample;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Demo {
    public static void main(String[] args) {
        File file1 = new File("test", "C:/user/home", "txt", 11);
        File file2 = new File("test", "C:/user/home", "txt", 11);
        File file3 = new File("video", "C:/user/home", "txt", 11);
        File file4 = new File("test", "C:/user/home", "txt", 11);
        File file5 = new File("myhome", "C:/user/home", "jpg", 120);
        // File file6 = new File("file6", "C:/user/document", "pdf", 230);

        File[] files = {file1, file2, file3, file4, file5, null};
        Storage storage = new Storage(files);

        FileReader fileReader = new FileReader();
        SimpleReader simpleReader = new SimpleReader();

        read(storage, fileReader);
        read(storage, simpleReader);
    }

    private static void read(Storage storage, Readable readable){
        System.out.println("method is starting");
        readable.readFilesForStorage(storage);
    }
}
