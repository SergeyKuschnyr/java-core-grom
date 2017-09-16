package library;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by Kushn_000 on 08.09.2017.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        Book book1 = new Book(1001, "Dos1", "Tishit..", "Sholokhov",
                "Zorya", 1990, new Date(2000, 9, 23));
        Book book2 = new Book(1002, "Dos2", "Ottsi..", "Turgenev",
                "Oktyabr", 1987, new Date(1987, 8, 23));
        Book book3 = new Book(1003, "Dos3", "Voina..", "Tolstoy",
                "Piter", 1991, new Date(1991, 2, 12));
//        Book book4 = new Book(1004, "Dos4", "Tikhiy..", "Sholokhov",
//                "Zorya", 1990, new Date(2000, 9, 23));
//        Book book5 = new Book(1005, "Dos5", "Skazka..", "Pushkin",
//                "allbook", 2007, new Date(2007, 5, 4));

        //Book[] books = {book1, book2, book3, book4, book5};

        User librarian1 = new User(1001, "Olya", "q@mail.com",
                "Sagaydachnogo", "Kiev", "+380507874523", "qwerty1");
        User librarian2 = new User(1002, "Kolya", "w@mail.com",
                "Sagaydachnogo", "Kiev", "+380507874523", "qwerty2");
        User librarian3 = new User(1003, "Vasya", "e@mail.com",
                "Sagaydachnogo", "Kiev", "+380507874523", "qwerty3");
//        User librarian4 = new User(1004, "Petya", "r@mail.com",
//                "Sagaydachnogo", "Kiev", "+380507874523", "qwerty4");
//        User librarian5 = new User(1005, "Egor", "t@mail.com",
//                "Sagaydachnogo", "Kiev", "+380507874523", "qwerty5");

        GeneralDAO<Book> generalDAO = new BookDAO();
        //System.out.println(Arrays.toString(generalDAO.getTs()));
        BookDAO bookDAO = new BookDAO();
        System.out.println(Arrays.toString(generalDAO.getTs()));
        try {
            generalDAO.add(book1);
            generalDAO.add(book2);
            generalDAO.add(book3);
//            System.out.println(Arrays.toString(bookDAO.getTs()));
        } catch (Exception e) {
            System.out.println("Error1");
        }

        System.out.println(Arrays.toString(generalDAO.getTs()));

//        generalDAO.add(book4);
//        generalDAO.add(book5);
        System.out.println();

        GeneralDAO<User> generalDAO2 = new GeneralDAO();
        generalDAO2.add(librarian1);
        generalDAO2.add(librarian2);
        generalDAO2.add(librarian3);
//        generalDAO2.add(librarian4);
//        generalDAO2.add(librarian5);

        System.out.println(Arrays.toString(generalDAO.getAll()));
        //System.out.println(Arrays.toString(generalDAO2.getTs()));

//        bookDAO.issue(book3, UserType.LIBRARIAN);

//        System.out.println("generalDAO.getAll()");
//        System.out.println(Arrays.toString(generalDAO2.getAll()));
//        System.out.println("bookDAO.getAll()");
//        System.out.println(Arrays.toString(bookDAO.getAll()));

        System.out.println();

            System.out.println("выдача");
            bookDAO.issue(book3, UserType.LIBRARIAN);
            System.out.println(Arrays.toString(generalDAO.getAll()));

            System.out.println();

        //try {
            System.out.println("возврат");
            //generalDAO.returnBook(book3, UserType.LIBRARIAN);
            //System.out.println(Arrays.toString(bookDAO.getAll()));

            //System.out.println();

            //System.out.println(Arrays.toString(bookDAO.getIssuedBooks(UserType.LIBRARIAN)));
//        } catch (Exception e) {
//            System.out.println("Error3");
//        }

//        System.out.println("librarian");
//        generalDAO2.del(librarian3, UserType.LIBRARIAN);
//        System.out.println(Arrays.toString(generalDAO2.getAll()));
//        System.out.println();
//        System.out.println("admin");
//        generalDAO2.del(librarian3, UserType.ADMIN);
//        System.out.println(Arrays.toString(generalDAO2.getAll()));
    }
}
