package library;

/**
 * Created by Kushn_000 on 07.09.2017.
 */
public class Book {
    private int id;
    private String author;
    private String name;
    private int yearOfIssue;
    private int countOfPage;

    public Book(int id, String author, String name, int yearIssue, int countPage) {
        this.id = id;
        this.author = author;
        this.name = name;
        this.yearOfIssue = yearIssue;
        this.countOfPage = countPage;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public int getCountOfPage() {
        return countOfPage;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", name='" + name + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", countOfPage=" + countOfPage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (yearOfIssue != book.yearOfIssue) return false;
        if (countOfPage != book.countOfPage) return false;
        if (!author.equals(book.author)) return false;
        return name.equals(book.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + yearOfIssue;
        result = 31 * result + countOfPage;
        return result;
    }
}
