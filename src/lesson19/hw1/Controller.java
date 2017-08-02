package lesson19.hw1;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class Controller {

    private Storage[] storage;

    public Controller(Storage[] storage) {
        this.storage = storage;
    }

    public Storage[] getStorage() {
        return storage;
    }

    public File put(Storage storage, File file) {
        if (!isSpace(storage, file)) {
            System.err.println("Storage overfull");
            return null;
        }
        if (doesTheFileExist(storage, file.getId()) != 0) {
            throw new RuntimeException("Same file already exist");
        }
        if (!fileFormatCheck(storage, file)) {
            throw new RuntimeException("File format is wrong");
        }
        if (searchEmptyPosition(storage) == 0) {
            throw new RuntimeException("Array overfull");
        }
        storage.getFiles()[searchEmptyPosition(storage)] = file;
        return file;
    }

    public void delete(Storage storage, File file) {
        if (doesTheFileExistForDel(storage, file) == 0) {
            throw new RuntimeException("File not find");
        }
        storage.getFiles()[doesTheFileExistForDel(storage, file)] = null;
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) {
        if (doesTheFileExist(storageFrom, id) == 0) {
            throw new RuntimeException("File don't find");
        }
        if (doesTheFileExist(storageTo, id) != 0) {
            throw new RuntimeException("Same file already exist");
        }
        if (isSpace(storageTo, storageFrom.getFiles()[doesTheFileExist(storageFrom, id)])) {
            throw new RuntimeException("Storage overfull");
        }
        if (searchEmptyPosition(storageTo) == 0) {
            throw new RuntimeException("Array overfull");
        }
        if (!fileFormatCheck(storageFrom, storageTo.getFiles()[doesTheFileExist(storageTo, id)])) {
            throw new RuntimeException("File format is wrong");
        }
        storageTo.getFiles()[searchEmptyPosition(storageTo)] = storageFrom.getFiles()[doesTheFileExist(storageFrom, id)];
        storageFrom.getFiles()[doesTheFileExist(storageFrom, id)] = null;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) {
        if (sumOfFileSize(storageFrom) + sumOfFileSize(storageTo) > storageTo.getStorageSize()) {
            throw new RuntimeException("Space don't enough");
        }
        if (!isEmptyPosition(storageFrom, storageTo)) {
            throw new RuntimeException("Array overfull");
        }
        if (fileFormatCheck2(storageFrom, storageTo)) {
            throw new RuntimeException("File format is wrong");
        }
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

    private boolean isSpace(Storage storageTo, File file) {
        return storageTo.getStorageSize() - sumOfFileSize(storageTo) > file.getSize();
    }

    private int doesTheFileExist(Storage storage, long id) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id) {
                return i;
            }
        }
        return 0;
    }

    private int doesTheFileExistForDel(Storage storage, File file) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (file != null) {
                if (storage.getFiles()[i].getName().equals(file.getName()) &&
                        storage.getFiles()[i].getId() == file.getId()) {
                    return i;
                }
            }
        }
        return 0;
    }

    private int searchEmptyPosition(Storage storage) {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return i;
            }
        }
        return 0;
    }

    private boolean isEmptyPosition(Storage storageFrom, Storage storageTo) {
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
        return count1 < count2;
    }

    private boolean fileFormatCheck(Storage storage, File file) {
        for (String fs : storage.getFormatSupported()) {
            if (fs != null && fs.equals(file.getFormat())) {
                return true;
            }
        }
        return true;
    }

    private boolean fileFormatCheck2(Storage storageFrom, Storage storageTo) {
        for (File file : storageFrom.getFiles()) {
            if (file != null && fileFormatCheck(storageTo, file)) {
                return false;
            }
        }
        return true;
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