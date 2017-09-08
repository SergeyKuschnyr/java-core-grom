package library;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 07.09.2017.
 */
public class LibrarianDAO {
    private Librarian[] librarians;

    public LibrarianDAO(Librarian[] librarians) {
        this.librarians = librarians;
    }

    public Librarian[] getLibrarians() {
        return librarians;
    }

    //add
    public Librarian add(Librarian librarian) throws Exception {
        if (librarian == null)
            return null;
        for (Librarian librarian1 : librarians)
            if (librarian1.equals(librarian))
                throw new Exception("The book is in base already");
        int index = emptyPlace();
        librarians[index] = librarian;
        return librarians[index];
    }

    //view
    public Librarian[] getAll() {
        return noNullItem(librarians);
    }

    //del
    public Librarian del(Librarian librarian) throws Exception {
        if (librarian == null)
            return null;
        int index = 0;
        for (Librarian librarian1 : librarians) {
            if (librarian1.equals(librarian)) {
                index++;
                break;
            }
        }
        if (index == 0)
            throw new Exception("No empty place");
        librarians[index] = null;
        return librarians[index];
    }

    private int emptyPlace() throws Exception {
        int index = 0;
        for (Librarian librarian : librarians) {
            if (librarian == null) {
                index++;
                break;
            }
        }
        if (index == 0)
            throw new Exception("No empty place");
        return (index - 1);
    }

    private Librarian[] noNullItem(Librarian[] librarians) {
        if (librarians == null || librarians.length == 0)
            return new Librarian[0];
        int index = 0;
        for (Librarian librarian : librarians)
            if (librarian != null)
                index++;
        if (index == 0)
            return new Librarian[0];
        Librarian[] outArray = new Librarian[index];
        index = 0;
        for (Librarian librarian : librarians)
            if (librarian != null) {
                outArray[index] = librarian;
                index++;
            }
        return outArray;
    }
    //logout

    @Override
    public String toString() {
        return "LibrarianDAO{" +
                "librarians=" + Arrays.toString(librarians) +
                '}';
    }
}
