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
        this.id = id;
        this.files = files;
        this.formatSupported = formatSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
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
}
