package lesson19.hw1;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class Storage {
    private long id;
    private File[] files;
    private String[] formatSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatSupported,
                   String storageCountry, long storageSize) {
        this.formatSupported = formatSupported;
        this.storageSize = storageSize;
        if (!checkFormatInArr(files)){
            throw new RuntimeException("File format is wrong in Array");
        }
        if (sumOfFileSize(files) > storageSize){
            throw new RuntimeException("Size of files more storage size");
        }
        this.id = id;
        this.files = files;
        this.storageCountry = storageCountry;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatSupported() {
        return formatSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    private boolean checkFormatInArr(File[] files) {
        for (File file : files) {
            if (file != null && !checkFormat(file)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFormat(File file) {
        for (String fileFormat : formatSupported) {
            if (file != null && file.getFormat().equals(fileFormat)) {
                return true;
            }
        }
        return false;
    }

    private int sumOfFileSize(File[] files) {
        int totalSize = 0;
        for (File file : files) {
            if (file != null)
                totalSize += file.getSize();
        }
        return totalSize;
    }
}
