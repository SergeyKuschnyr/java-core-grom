package lesson19.hw1;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class Controller {

    public File put(Storage storageTo, File file) throws Exception {
        if (file == null && storageTo != null) {
            System.out.println("error: input file or storage is null");
            return null;
        }

        for (int i = 0; i < storageTo.getFiles().length; i++) {
            if (storageTo.getFiles()[i] != null) {
                if (storageTo.getFiles()[i].getId() == file.getId()) {
                    throw new Exception("same file already exist");
                }
            }
        }
        fileFormatCheck(storageTo, file);
        isSpace(storageTo, file);
        int index = searchNullPosition(storageTo);

        storageTo.getFiles()[index] = file;

        return file;
    }

    public void delete(Storage storage, File file) throws Exception {
        if (storage != null && file != null) {
            storage.getFiles()[getIndex(storage, file)] = null;
        } else
            System.out.println("Storage don't create or file is null");
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom != null && storageTo != null) {
            int indexFrom = getIndex(storageFrom, id);
            getIndex(storageTo, id);
            isSpace(storageTo, storageFrom.getFiles()[indexFrom]);
            fileFormatCheck(storageTo, storageFrom.getFiles()[indexFrom]);
            int indexTo = searchNullPosition(storageTo);

            storageTo.getFiles()[indexTo] = storageFrom.getFiles()[indexFrom];
            storageFrom.getFiles()[indexFrom] = null;
        }

    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom != null && storageTo != null) {
            if (sumOfFileSize(storageFrom) + sumOfFileSize(storageTo) > storageTo.getStorageSize()) {
                throw new Exception("Space don't enough");
            }
            isEmptyPosition(storageFrom, storageTo);
            fileFormatCheck(storageFrom, storageTo);
            for (int i = 0; i < storageFrom.getFiles().length; i++) {
                if (storageFrom.getFiles()[i] != null) {
                    for (int j = 0; j < storageTo.getFiles().length; j++) {
                        if (storageTo.getFiles()[j] == null) {
                            storageTo.getFiles()[j] = storageFrom.getFiles()[i];
                            break;
                        }
                    }
                }
            }
        }
    }

    private void isSpace(Storage storageTo, File file) throws Exception {
        if (!(storageTo.getStorageSize() - sumOfFileSize(storageTo) > file.getSize()))
            throw new Exception("Storage overfull");
    }

    private static int searchNullPosition(Storage storage) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return i;
            }
        }
        throw new Exception("Array overfull");
    }

    private int getIndex(Storage storage, long id) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id) {
                return i;
            }
        }
        throw new Exception("put file in storage with id: " + storage.getId() + "error");
    }

    private int getIndex(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (file != null) {
                if (storage.getFiles()[i].getName().equals(file.getName()) &&
                        storage.getFiles()[i].getId() == file.getId()) {
                    return i;
                }
            }
        }
        throw new Exception("put file in storage with id: " + storage.getId() + "error");
    }

    private void isEmptyPosition(Storage storageFrom, Storage storageTo) throws Exception {
        int count1 = 0;
        int count2 = 0;
        for (File file : storageFrom.getFiles()) {
            if (file != null) {
                count1++;
            }
        }
        for (File file : storageTo.getFiles()) {
            if (file == null) {
                count2++;
            }
        }
        if (count1 > count2)
            throw new Exception("Array overfull");
    }

    private boolean fileFormatCheck(Storage storage, File file) throws Exception {
        for (String fs : storage.getFormatSupported()) {
            if (fs != null && fs.equals(file.getFormat())) {
                return true;
            }
        }
        throw new Exception("File format is wrong");
    }

    private void fileFormatCheck(Storage storageFrom, Storage storageTo) throws Exception {
        for (File file : storageFrom.getFiles()) {
            if (file != null) {
                fileFormatCheck(storageTo, file);
            }
        }
    }

    private int sumOfFileSize(Storage storage) {
        int totalSize = 0;
        for (File file1 : storage.getFiles()) {
            if (file1 != null)
                totalSize += file1.getSize();
        }
        return totalSize;
    }
}