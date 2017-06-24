package lesson15.equals;

/**
 * Created by Kushn_000 on 24.06.2017.
 */
public class File {
    int size;
    String path;
    String extention;

    public File(int size, String path, String extention) {
        this.size = size;
        this.path = path;
        this.extention = extention;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        return path.equals(file.path);
    }

    @Override
    public int hashCode() {
        return path.hashCode();
    }

/* @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        File file = (File) o;

        if (size != file.size) return false;
        if (!path.equals(file.path)) return false;
        return extention.equals(file.extention);
    }

    @Override
    public int hashCode() {
        int result = size;
        result = 31 * result + path.hashCode();
        result = 31 * result + extention.hashCode();
        return result;
    }*/
}
