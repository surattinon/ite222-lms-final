package LMS;

import java.util.Scanner;

public class App {

  // Declare the APP_NAME as a static fianl variable
  private static final String APP_NAME = "Stamford Library Management System";

  public static void main(String[] args) {
    // Use 2D array to represent shelves and slots of books
    BookDetail[] booksArray = new BookDetail[5]; // 3 shelves, each with 5 slots
    StudentDetails[] studentsArray = new StudentDetails[5];

    // Populating the array with BookDetail objects
    // | ID | Title | Author | Publisher |

    // 1st Shelve
    booksArray[0] = new BookDetail("b001", "Title1", "Author1", "Pub1");
    booksArray[1] = new BookDetail("b002", "Title2", "Author2", "Pub2");
    booksArray[2] = new BookDetail("b003", "Title2", "Author2", "Pub2");
    booksArray[3] = new BookDetail("b004", "Title2", "Author2", "Pub2");
    booksArray[4] = new BookDetail("b005", "Title2", "Author2", "Pub2");

    // Initialize a BookDatabase and pass the 2D array of books trough the
    // constructor
    BookDatabase bookDB = new BookDatabase(booksArray);
    StudentDB studentDB = new StudentDB(studentsArray);

    // Innitiate a Librarian object with ID and password
    Librarian librarian = new Librarian(12123, "password");

    studentsArray[0] = new StudentDetails("2104270033", "Pumin", "", "");
    studentsArray[1] = new StudentDetails("2105250007", "Bas", "", "");
    studentsArray[2] = new StudentDetails("s003", "Panthorn", "", "");
    studentsArray[3] = new StudentDetails("s004", "Bananascence", "", "");
    studentsArray[4] = new StudentDetails("s005", "Student5", "", "");

    // Login prompt
    Scanner scanner = new Scanner(System.in);
    System.out.println("\nStamford Librarian Login | " + APP_NAME);
    System.out.print("Enter librarian ID: ");
    int id = scanner.nextInt();
    System.out.print("Enter password: ");
    String password = scanner.next();

    // Check if ID and password match
    if (librarian.login(id, password)) {
      System.out.println("Login successful!\n");
      System.out.println("Welcome to " + APP_NAME);
      boolean exit = false;

      // Loop for the main menu while exit is false
      while (!exit) {
        System.out.println("\nTotal books borrowed: " + Librarian.getTotalBooksBorrowed());
        System.out.println("----------------------------");
        System.out.println("1. View Books");
        System.out.println("2. Borrow a Book");
        System.out.println("3. Return a Book");
        System.out.println("4. View Students History");
        System.out.println("5. Exit");
        System.out.println("----------------------------");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();

        // Switch case for choices
        switch (choice) {
          case 1:
            librarian.viewBooks(bookDB); // View books
            break;
          case 2:
            System.out.print("Enter the ID of the book to borrow: ");
            scanner.nextLine(); // consume newline
            String borrowID = scanner.nextLine();
            System.out.print("Enter student ID: ");
            String studentID = scanner.nextLine();
            System.out.print("Enter burrow date: ");
            String burrowDate = scanner.nextLine();

            librarian.borrowBook(bookDB, studentDB, borrowID, studentID, burrowDate);

            break;

          case 3:
            System.out.print("Enter the ID of the book to return: ");
            scanner.nextLine(); // consume newline
            String returnID = scanner.nextLine();
            librarian.returnBook(bookDB, returnID, studentDB); // Return book
            break;

          case 4:
            System.out.println("Student History");
            librarian.showStudent(studentDB);
            break;
          case 5:
            exit = true; // Set exit to true to break the loop
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
