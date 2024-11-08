package main.java.com.harist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Simple Library Application to manage books and lending.
 * Provides functionality to add, remove, search, and display books.
 */
public class LibraryApp {
    private List<Book> books = new ArrayList<>();

    /**
     * Main method to run the library application.
     * Provides a text-based menu to interact with the library system.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        LibraryApp library = new LibraryApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    System.out.println("Book added!");
                    break;
                case 2:
                    System.out.print("Enter title of book to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    break;
                case 3:
                    System.out.print("Enter title of book to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = library.searchBook(searchTitle);
                    if (book != null) {
                        System.out.println("Found: " + book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    library.displayBooks();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }

    /**
     * Adds a new book to the library collection.
     *
     * @param book The book object to be added.
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Removes a book from the library collection by its title.
     * If the book with the specified title is not found, no action is taken.
     *
     * @param title The title of the book to be removed.
     */
    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
        System.out.println("Book removed if it existed.");
    }

    /**
     * Searches for a book by its title.
     *
     * @param title The title of the book to search for.
     * @return The book object if found, or null if not found.
     */
    public Book searchBook(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    /**
     * Displays all books currently in the library collection.
     * If no books are present, an empty list is shown.
     */
    public void displayBooks() {
        System.out.println("\nBooks in Library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
