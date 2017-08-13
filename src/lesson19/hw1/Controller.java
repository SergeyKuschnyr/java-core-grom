package lesson19.hw1;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class Controller {

    public File put(Storage storageTo, File file) throws Exception {
        isFile(storageTo, file.getId());
        fileFormatCheck(storageTo, file);
        isSpace(storageTo, file);
        int index = searchNullPosition(storageTo);

        storageTo.getFiles()[index] = file;

        return file;
    }

    public void delete(Storage storage, File file) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i].getName().equals(file.getName()) &&
                    storage.getFiles()[i].getId() == file.getId()) {
                storage.getFiles()[i] = null;
                return;
            }
        }
        throw new Exception("File with id: " + file.getId() + " not exist in storage with id: " +
                storage.getId());
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        int indexFrom = 0;
        for (int i = 0; i < storageFrom.getFiles().length; i++) {
            if (storageFrom.getFiles()[i] != null && storageFrom.getFiles()[i].getId() == id) {
                indexFrom = i + 1;
                break;
            }
        }
        if (indexFrom == 0)
            throw new Exception("file with id: " + id + " not found in storage with id: " + storageFrom.getId());

        indexFrom = indexFrom - 1;
        isFile(storageTo, id);
        isSpace(storageTo, storageFrom.getFiles()[indexFrom]);
        fileFormatCheck(storageTo, storageFrom.getFiles()[indexFrom]);
        int indexTo = searchNullPosition(storageTo);

        storageTo.getFiles()[indexTo] = storageFrom.getFiles()[indexFrom];
        storageFrom.getFiles()[indexFrom] = null;
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (sumOfFileSize(storageFrom) + sumOfFileSize(storageTo) > storageTo.getStorageSize()) {
            throw new Exception("In storage with id: " + storageTo.getId() + " the space isn't enough");
        }
        isEmptyPosition(storageFrom, storageTo);
        fileFormatCheck(storageFrom, storageTo);
        for (File file : storageFrom.getFiles()) {
            for (File file1 : storageTo.getFiles()) {
                if (file.getId() == file1.getId()) {
                    throw new Exception("File with id: " + file.getId() + " already exist in storage with id: " +
                            storageTo.getId());
                }
            }
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void isSpace(Storage storageTo, File file) throws Exception {
        if (!(storageTo.getStorageSize() - sumOfFileSize(storageTo) > file.getSize()))
            throw new Exception("Storage with id: " + storageTo.getId() + " is overfull");
    }

    private static int searchNullPosition(Storage storage) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] == null) {
                return i;
            }
        }
        throw new Exception("Array from storage with id: " + storage.getId() + " is overfull");
    }

    private void isFile(Storage storage, long id) throws Exception {
        for (int i = 0; i < storage.getFiles().length; i++) {
            if (storage.getFiles()[i] != null && storage.getFiles()[i].getId() == id) {
                throw new Exception("file with id: " + id + " already exist in storage with id: " + storage.getId());
            }
        }
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
            throw new Exception("Array from storage with id: " + storageTo.getId() + " is overfull");
    }

    private void fileFormatCheck(Storage storage, File file) throws Exception {
        for (String fs : storage.getFormatSupported()) {
            if (fs != null && fs.equals(file.getFormat())) {
                return;
            }
        }
        throw new Exception("File format with id: " + file.getId() + " is wrong");
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
