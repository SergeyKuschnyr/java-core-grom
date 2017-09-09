package library;

import java.util.Date;

/**
 * Created by Kushn_000 on 07.09.2017.
 */
public class Book {
    private int id;
    private String callno;
    private String name;
    private String author;
    private String published;
    private int issued;
    private Date addedDate;

    public Book(int id, String callno, String name, String author, String published, int issued, Date addedDate) {
        this.id = id;
        this.callno = callno;
        this.name = name;
        this.author = author;
        this.published = published;
        this.issued = issued;
        this.addedDate = addedDate;
    }

    public int getId() {
        return id;
    }

    public String getCallno() {
        return callno;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublished() {
        return published;
    }

    public int getIssued() {
        return issued;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return callno.equals(book.callno);
    }

    @Override
    public int hashCode() {
        return callno.hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", callno='" + callno + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", published='" + published + '\'' +
                ", issued=" + issued +
                ", addedDate=" + addedDate +
                '}';
    }
}


