package LMS;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    // Use 2D array to represent shelves and slots of books
    BookDetail[][] booksArray = new BookDetail[3][5]; // 3 shelves, each with 5 slots

    // Populating the array with BookDetail objects

    // 1st Shelve
    booksArray[0][0] = new BookDetail("b001", "Title1", "Author1", "Pub1");
    booksArray[0][1] = new BookDetail("b002", "Title2", "Author2", "Pub2");
    booksArray[0][2] = new BookDetail("b003", "Title2", "Author2", "Pub2");
    booksArray[0][3] = new BookDetail("b004", "Title2", "Author2", "Pub2");
    booksArray[0][4] = new BookDetail("b005", "Title2", "Author2", "Pub2");

    // 2nd Shelve
    booksArray[1][0] = new BookDetail("b006", "Title1", "Author1", "Pub1");
    booksArray[1][1] = new BookDetail("b007", "Title2", "Author2", "Pub2");
    booksArray[1][2] = new BookDetail("b008", "Title2", "Author2", "Pub2");
    booksArray[1][3] = new BookDetail("b009", "Title2", "Author2", "Pub2");
    booksArray[1][4] = new BookDetail("b010", "Title2", "Author2", "Pub2");

    // 3rd Shelve
    booksArray[2][0] = new BookDetail("b011", "Title1", "Author1", "Pub1");
    booksArray[2][1] = new BookDetail("b012", "Title2", "Author2", "Pub2");
    booksArray[2][2] = new BookDetail("b013", "Title2", "Author2", "Pub2");
    booksArray[2][3] = new BookDetail("b014", "Title2", "Author2", "Pub2");
    booksArray[2][4] = new BookDetail("b015", "Title2", "Author2", "Pub2");

    // BookDB instance with the 2D array
    BookDatabase bookDB = new BookDatabase(booksArray);

    // Creating a librarian
    Librarian librarian = new Librarian(12123, "password");

    // Logging in the librarian
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nStamford Librarian Login");
    System.out.print("Enter librarian ID: ");
    int id = scanner.nextInt();
    System.out.print("Enter password: ");
    String password = scanner.next();

    if (librarian.login(id, password)) {
      System.out.println("Login successful!\n");
      System.out.println("Welcome to Stamford Library");
      boolean exit = false;
      while (!exit) {
        System.out.println("Total books borrowed: " + Librarian.getTotalBooksBorrowed());
        System.out.println("----------------------------");
        System.out.println("1. View Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. Exit");
        System.out.println("----------------------------");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
          case 1:
            librarian.viewBooks(bookDB);
            break;
          case 2:
            System.out.print("Enter the ID of the book to borrow: ");
            scanner.nextLine(); // consume newline
            String borrowTitle = scanner.nextLine();
            librarian.borrowBook(bookDB, borrowTitle);
            break;
          case 3:
            System.out.print("Enter the ID of the book to return: ");
            scanner.nextLine(); // consume newline
            String returnTitle = scanner.nextLine();
            librarian.returnBook(bookDB, returnTitle);
            break;
          case 4:
            exit = true;
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid option. Please try again.");
            break;
        }
      }
    } else {
      System.out.println("Login failed!");
    }
    scanner.close();
  }
}
