package lesson11.biginterfaceexample;

/**
 * Created by Kushn_000 on 30.04.2017.
 */
public class Storage {
    private File[] files = new File[5];

    public Storage(File[] files) {
        this.files = files;
    }

    public File[] getFiles() {
        return files;
    }
}
