package lesson19.hw1;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class Demo {
    public static void main(String[] args) {

        File file1 = fileCreating(12345l, "qwerty1", "txt", 1);
        File file2 = fileCreating(1234l, "qwerty2", "txt", 1);
        File file3 = fileCreating(123l, "qwerty3", "jpg", 1);
        File file4 = fileCreating(123456l, "qwerty4", "exe", 1);
        File file5 = fileCreating(123457l, "qwerty5", "txt", 1);

        File file6 = fileCreating(123458l, "qwerty6", "exe", 1);
        File file7 = fileCreating(123459l, "qwerty7", "jpg", 1);
        File file8 = fileCreating(1234510l, "qwerty8", "exe", 1);
        File file9 = fileCreating(123457l, "qwerty9", "txt", 1);
        File file10 = fileCreating(1234511l, "qwerty10", "jpg", 1);

        File[] filesFrom = {file1, file2, file3, file4};
        File[] filesTo = {file6, file7, file8, file9, file10, null, null, null, null, null};

        String[] formatFileFrom = {"txt", "exe", "jpg"};
        String[] formatFilesTo = {"txt", "exe", "jpg"};

        Storage storageFrom = storageCreating(12345l, filesFrom, formatFileFrom, "Ukraine", 7);
        Storage storageTo = storageCreating(12340l, filesTo, formatFilesTo, "USA", 9);

        Storage[] storages = {storageFrom, storageTo};

        Controller controller = new Controller(storages);

        controllerMethodCheck(storageFrom, storageTo, controller);
    }

    public static void controllerMethodCheck(Storage storageFrom, Storage storageTo, Controller controller) {

        System.out.println("------------put method check");
        print(storageTo);
        try {
            if (storageTo != null && storageFrom != null) {
                controller.put(storageTo, storageFrom.getFiles()[1]);
            } else
                System.out.println("storage don't create");
        } catch (Exception rt) {
            System.out.println("error: " + rt.getMessage());
        }
        print(storageTo);
        System.out.println();

//        print(storageFrom);
//        try {
//            if (storageTo != null && storageFrom != null) {
//                controller.put(storageFrom, storageFrom.getFiles()[1]);
//            } else
//                System.out.println("storage don't create");
//        } catch (Exception rt) {
//            System.out.println("error: " + rt.getMessage());
//        }
//        print(storageFrom);
        System.out.println();

        System.out.println("--------------------delete method check");
        print(storageTo);
        try {
            controller.delete(storageTo, storageTo.getFiles()[3]);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        print(storageTo);
        System.out.println();


        System.out.println("--------------transferFile method check");
        print(storageFrom);
        print(storageTo);
        try {
            controller.transferFile(storageFrom, storageTo, 1234l);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        print(storageFrom);
        print(storageTo);
        System.out.println();


        System.out.println("----------------transferAll method check");
        print(storageFrom);
        print(storageTo);
        try {
            controller.transferAll(storageFrom, storageTo);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        print(storageFrom);
        print(storageTo);
        System.out.println();
    }

    public static void print(Storage storage) {
        if (storage != null) {
            System.out.print("{");
            for (File file : storage.getFiles()) {
                if (file != null) {
                    System.out.print(file.getId() + ", ");
                } else System.out.print("null, ");
            }
            System.out.println("}");
        }
        ;
    }

    public static File fileCreating(long id, String name, String format, long size) {
        try {
            return new File(id, name, format, size);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        return null;
    }

    private static Storage storageCreating(long id, File[] files, String[] fileFormat,
                                           String storageCountry, long storageSize) {
        try {
            return new Storage(id, files, fileFormat, storageCountry, storageSize);
        } catch (Exception rt) {
            System.out.println("error: " + rt.getMessage());
            return null;
        }
    }
}
