package library;

import java.util.Arrays;

/**
 * Created by Kushn_000 on 07.09.2017.
 */
public class BookDAO {
    private Book[] books = new Book[10];
    private Book[] issuedBooks = new Book[10];

    public BookDAO(Book[] books, Book[] issuedBooks) {
        this.books = books;
        this.issuedBooks = issuedBooks;
    }

    public Book[] getBooks() {
        return books;
    }

    public Book[] getIssuedBooks() {
        return issuedBooks;
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    //add
    public Book add(Book book) throws Exception {
        if (book == null)
            return null;
        for (Book book1 : books)
            if (book1.equals(book))
                throw new Exception("The book is in base already");
        int index = emptyPlace();
        books[index] = book;
        return books[index];
    }

    //view
    public Book[] getAll() {
        return noNullItem(books);
    }

    //issue view
    public Book[] getIssueBook() {
        return noNullItem(issuedBooks);
    }

    //issue
    public Book issue(Book book) {
        if (book == null)
            return null;
        return bookMove(books, issuedBooks, book);
    }

    //return
    public Book returnBook(Book book) {
        if (book == null)
            return null;
        return bookMove(issuedBooks, books, book);
    }

    private int emptyPlace() throws Exception{
        int index = 0;
        for (Book book1 : books) {
            if (book1 == null) {
                index++;
                break;
            }
        }
        if (index == 0)
            throw new Exception("No empty place");
        return (index - 1);
    }

    private Book[] noNullItem(Book[] books) {
        if (books == null || books.length == 0)
            return new Book[0];
        int index = 0;
        for (Book book : books)
            if (book != null)
                index++;
        if (index == 0)
            return new Book[0];
        Book[] outArray = new Book[index];
        index = 0;
        for (Book book : books)
            if (book != null) {
                outArray[index] = book;
                index++;
            }
        return outArray;
    }

    private Book bookMove(Book[] book1, Book[] book2, Book book) {
        if (book == null)
            return null;
        int index = 0;
        for (Book tempBook : book1)
            if (tempBook.equals(book)) {
                index++;
                break;
            }
        int index2 = 0;
        for (Book tempBook : book2)
            if (tempBook == null) {
                index2++;
                book1[index - 1] = null;
                book2[index2 - 1] = book;
                break;
            }
        return book2[index2 - 1];
    }
    //logout

    @Override
    public String toString() {
        return "BookDAO{" +
                "books=" + Arrays.toString(books) +
                ", issuedBooks=" + Arrays.toString(issuedBooks) +
                '}';
    }
}
