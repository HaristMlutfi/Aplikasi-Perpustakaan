package main.java.com.harist;

/**
 * Represents a book in the library.
 * Each book has a title and an author.
 */
public class Book {
    private String title;
    private String author;

    /**
     * Constructs a new book with the specified title and author.
     *
     * @param title  The title of the book.
     * @param author The author of the book.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Retrieves the title of the book.
     *
     * @return The book's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a string representation of the book, including its title and author.
     *
     * @return A string representation of the book.
     */
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author;
    }
}
