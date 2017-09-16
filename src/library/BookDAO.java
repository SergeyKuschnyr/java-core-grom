package library;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 09.09.2017.
 */
public class BookDAO extends GeneralDAO{

    private GeneralDAO <Book>generalDAO;
    private Book[] issuedBooks;

    public BookDAO() {
        this.issuedBooks = new Book[10];
    }

    public Book[] getIssuedBooks() {
        return issuedBooks;
    }

    //issue
    public Book issue(Book book, UserType user) throws Exception{
        if (user == UserType.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        if (book == null)
            return null;
        if (generalDAO  == null)
            return null;
        System.out.println("test7");
        System.out.println(Arrays.toString(generalDAO.getAll()));
        System.out.println("test8");
        Book tempBook = (Book) bookMove(generalDAO.getAll(), issuedBooks, book);
        System.out.println("Book issued successfully");
        return tempBook;
    }

    //return
    public Book returnBook(Book book, UserType user) throws Exception{
        if (user == UserType.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        if (book == null)
            return null;
        Book tempBook = (Book) bookMove(issuedBooks, generalDAO.getAll(), book);
        System.out.println("Book returned successfully");
        return tempBook;
    }

        //view issued book
    public Book[] getIssuedBooks(UserType user) throws Exception{
        if (user == UserType.ADMIN) {
            System.out.println("Sorry. This operation don't enable for you");
            return null;
        }
        return (Book[]) noNullItem(issuedBooks);
    }
}
