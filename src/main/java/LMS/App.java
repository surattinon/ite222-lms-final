package LMS;

import java.util.Scanner;

public class App {

    // Fields
    // Declare the APP_NAME as a static fianl variable
    private static final String APP_NAME = "Stamford Library Management System";

    public static void main(String[] args) {
        // Declare arrays for bookDetails and studentDetails
        BookDetail[] booksDetails = new BookDetail[5];
        StudentDetail[] studentDetails = new StudentDetail[5];

        // Populating the array with bookDetails objects and pass book details trough constructor
        // Format: | ID | Title | Author | Publication |
        booksDetails[0] = new BookDetail(
            "b001",
            "The Great Gatsby",
            "F. Scott Fitzgerald",
            "1925"
        );
        booksDetails[1] = new BookDetail(
            "b002",
            "Anna Karenina",
            "Anna Karenina",
            "1878"
        );
        booksDetails[2] = new BookDetail(
            "b003",
            "War and Peace",
            "Leo Tolstoy",
            "1865"
        );
        booksDetails[3] = new BookDetail(
            "b004",
            "Lolita",
            "Vladimir Nabokov",
            "1995"
        );
        booksDetails[4] = new BookDetail(
            "b005",
            "Frieren",
            "Kanehito Yamada",
            "2020"
        );

        // Populating the array with bookDetails objects and pass book details trough constructor
        // Format: | Student ID | Name | (empty string for last two arguments)
        studentDetails[0] = new StudentDetail("2104270033", "Pumin", "", "");
        studentDetails[1] = new StudentDetail("2105250007", "Bas", "", "");
        studentDetails[2] = new StudentDetail("2207150010", "Pantorn", "", "");
        studentDetails[3] = new StudentDetail("2123456789", "Ana", "", "");
        studentDetails[4] = new StudentDetail("2129876543", "Suphakid", "", "");

        // Initialize a bookDB and studentDB and pass all arrays trough constructor
        BookDatabase bookDB = new BookDatabase(booksDetails);
        StudentDatabase studentDB = new StudentDatabase(studentDetails);

        // Innitiate a librarian object and pass them trough constructor
        Librarian librarian = new Librarian(1234567890, "librarian123");

        // Login prompt
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nStamford Librarian Login | " + APP_NAME);
        System.out.print("Enter librarian ID: ");
        int id = scanner.nextInt(); // Recieve input and store in "id"
        System.out.print("Enter password: ");
        String password = scanner.next(); // Recieve input and store in "password"

        // Check if ID and password match with login method in librarian object
        if (librarian.login(id, password)) { // pass variable id and password trough method arguments
            System.out.println("Login successful!\n");
            System.out.println("Welcome to " + APP_NAME); // Display App name with static final variable
            boolean exit = false; // declare boolean "exit" and set to false at first

            // Loop for the main menu while exit is false
            while (!exit) {
                // Print total book borrowed with static variable from Librarian class
                System.out.println(
                    "\nTotal books borrowed: " +
                    Librarian.getTotalBooksBorrowed()
                );
                System.out.println("--------------------------------");
                System.out.println("1. Borrow a Book");
                System.out.println("2. Return a Book");
                System.out.println("3. View Books");
                System.out.println("4. View Student Borrow History");
                System.out.println("5. Exit");
                System.out.println("--------------------------------");
                System.out.print("Choose an option ( Enter 1 - 5 ): ");
                int choice = scanner.nextInt(); // Recieve input and store in "choice"

                // Switch case for choices
                switch (choice) {
                    case 1:
                        System.out.print(
                            "Enter the ID of the book to borrow (Example: \"b00X\"): "
                        );
                        scanner.nextLine(); // Consume newline
                        String borrowID = scanner.nextLine(); // Recieve input and store in "borrowID"
                        System.out.print("Enter student ID: ");
                        String studentID = scanner.nextLine(); // Recieve input and store in "studentID"
                        System.out.print(
                            "Enter borrow date (Format \"DD-MM-YY\"): "
                        );
                        String burrowDate = scanner.nextLine(); // Recieve input and store in "borrowDate"

                        // Call borrowBook method and pass bookDB, studentDB and variable above trough arguments
                        librarian.borrowBook(
                            bookDB,
                            studentDB,
                            borrowID,
                            studentID,
                            burrowDate
                        );
                        break;
                    case 2:
                        System.out.print(
                            "Enter the ID of the book to return (Example: \"b00X\"): "
                        );
                        scanner.nextLine(); // Consume newline
                        String returnID = scanner.nextLine(); // Recieve input and store in "returnID"

                        // Call returnBook method and pass bookDB, returnID and studentDB trough arguments
                        librarian.returnBook(bookDB, returnID, studentDB);
                        break;
                    case 3:
                        librarian.viewBooks(bookDB); // Call viewBook method and pass bookDB trough argument
                        break;
                    case 4:
                        System.out.println("Student Borrow History");

                        // Call showStudent method and pass studentDB trough argument
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
            System.out.println("Login failed!"); // Display if id and password does not match
        }
        scanner.close(); // Close scanner
    }
}
