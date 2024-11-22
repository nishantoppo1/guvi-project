import java.util.ArrayList;
import java.util.Scanner;

// Book class to store book details
class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isIssued;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("The book has been issued.");
        } else {
            System.out.println("This book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("The book has been returned.");
        } else {
            System.out.println("This book was not issued.");
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + ISBN + ", Issued: " + (isIssued ? "Yes" : "No");
    }
}

// Library class to manage books
class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author, String ISBN) {
        Book book = new Book(title, author, ISBN);
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public void issueBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.issueBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                book.returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLibrary Management System:");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter book ISBN: ");
                    String ISBN = scanner.nextLine();
                    library.addBook(title, author, ISBN);
                    break;
                case 2:
                    library.viewAllBooks();
                    break;
                case 3:
                    System.out.print("Enter ISBN to issue book: ");
                    ISBN = scanner.nextLine();
                    library.issueBook(ISBN);
                    break;
                case 4:
                    System.out.print("Enter ISBN to return book: ");
                    ISBN = scanner.nextLine();
                    library.returnBook(ISBN);
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
