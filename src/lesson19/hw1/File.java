package lesson19.hw1;

/**
 * Created by Kushn_000 on 29.07.2017.
 */
public class File {
    private long id;
    private String name;
    private String format;
    private long size;

    public File( long id, String name, String format,long size){
        try {
            checkNameLength(name);
            this.id = id;
            this.name = name;
            this.format = format;
            this.size = size;
        }catch (Exception e){
            System.out.println("error: " + e.getMessage());

        }
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public long getSize() {
        return size;
    }

    private boolean checkNameLength(String name) throws Exception {
        if (name.length() > 10) {
            throw new Exception("Input name is mistake");
        }
        return true;
    }
}
