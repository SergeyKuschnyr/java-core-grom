package lesson18.exercise1;

/**
 * Created by Kushn_000 on 24.07.2017.
 */
public class Task {
    public static void main(String[] args) {
        FileStorage fileStorage = new FileStorage();
        String[] fileNames = {"test1", "test2"};
        String[] fileNames2 = {"test1", "test2", "test3", "test4", "test5"};
        String[] fileNames3 = {};
        String[] fileNames4 = {null, null};
        String[] fileNames5 = {null, null, null, null, null};


        fileStorage.setFiles(fileNames);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        fileStorage.setFiles(fileNames2);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        fileStorage.setFiles(fileNames3);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        fileStorage.setFiles(fileNames4);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");

        fileStorage.setFiles(fileNames5);
        System.out.println("Start printing name...");
        printer(fileStorage);
        System.out.println("Done");
    }

    public static void printer(Storage storage){
        String[] names = storage.getFiles();

        try {
            System.out.println("5th name is " + names[4]);
        }catch (Exception e){
            System.out.println("5th name can not be found...");
        }
    }
}
