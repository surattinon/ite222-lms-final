package LMS;

/** Librarian */
public class Librarian {
  private int id;
  private String password;
  private static int totalBooksBorrowed = 0; // Static variable to track total books borrowed

  // Constructor to initialize Librarian with ID and password
  public Librarian(int id, String password) {
    this.id = id;
    this.password = password;
  }

  // Method to check if the ID and password match
  public boolean login(int id, String password) {
    return this.id == id && this.password.equals(password);
  }

  // Method to view all books in the library in a table format
  public void viewBooks(BookDatabase bookDB) {
    BookDetail[][] books = bookDB.getBooks(); // Get the 2D array of books
    for (int row = 0; row < books.length; row++) { // Loop through the rows (shelves)
      System.out.println("\nShelf: " + (row + 1));
      System.out.println(
          "-------------------------------------------------------------------------------------------");
      System.out.printf(
          "| %-10s| %-20s| %-20s| %-20s| %-10s|\n",
          "ID", "Title", "Author", "Publication", "Available");
      System.out.println(
          "-------------------------------------------------------------------------------------------");
      for (int col = 0; col < books[row].length; col++) { // Loop through the columns (slots)
        BookDetail book = books[row][col]; // Set data at the current array position to book object
        book.getBookTable(); // Call the getBookTable method to print book details
      }
      System.out.println(
          "-------------------------------------------------------------------------------------------");
    }
  }

  // Method to borrow a book by ID
  public void borrowBook(BookDatabase bookDB, String bookID) {
    BookDetail[][] books = bookDB.getBooks(); // Get the 2D array of books
    for (int row = 0; row < books.length; row++) { // Loop through the rows (shelves)
      for (int col = 0; col < books[row].length; col++) { // Loop through the columns (slots)
        BookDetail book = books[row][col]; // Set data at the current array position to book object
        if (book.getBookID().equals(bookID)) { // Check if the book ID matches the input
          // call the borrowBook method to check if the book is available for borrowing
          if (book.isNotBorrow()) {
            totalBooksBorrowed++; // Increment the total books borrowed
            System.out.printf(
                "Book ID: %s | Title: %s \nStatus: has been borrowed.\n",
                bookID, book.getBookTitle());
          } else {
            System.out.println("The book is not available for borrowing.");
          }
          return;
        }
      }
    }
    System.out.println("Book not found."); // if condition is not met, print book not found
  }

  // Method to return a book by ID
  public void returnBook(BookDatabase bookDB, String bookID) {
    BookDetail[][] books = bookDB.getBooks(); // Get the 2D array of books
    for (int row = 0; row < books.length; row++) { // Loop through the rows (shelves)
      for (int col = 0; col < books[row].length; col++) { // Loop through the columns (slots)
        BookDetail book = books[row][col]; // Set data at the current array position to book object
        if (book.getBookID().equals(bookID)) { // Check if the book ID matches the input
          totalBooksBorrowed--; // Decrement the total books borrowed
          book.returnBook(); // Call the returnBook method to set the book as available
          System.out.printf(
              "Book ID: %s | Title: %s \nStatus: has been returned.\n",
              bookID, book.getBookTitle());
          return;
        }
      }
    }
    System.out.println("Book not found."); // if condition is not met, print book not found
  }

  // Static method to get the total number of books borrowed
  public static int getTotalBooksBorrowed() {
    return totalBooksBorrowed;
  }
}
