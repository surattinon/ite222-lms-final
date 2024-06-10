package LMS;

/** Librarian */
public class Librarian {
  private int id;
  private String password;
  private static int totalBooksBorrowed = 0; // Static variable to track total books borrowed

  public Librarian(int id, String password) {
    this.id = id;
    this.password = password;
  }

  public boolean login(int id, String password) {
    return this.id == id && this.password.equals(password);
  }

  public void viewBooks(BookDatabase bookDB) {
    BookDetail[][] books = bookDB.getBooks();
    for (int row = 0; row < books.length; row++) {
      System.out.println("\nShelf: " + (row + 1));
      System.out.println(
          "-------------------------------------------------------------------------------------------");
      System.out.printf(
          "| %-10s| %-20s| %-20s| %-20s| %-10s|\n",
          "ID", "Title", "Author", "Publication", "Available");
      System.out.println(
          "-------------------------------------------------------------------------------------------");
      for (int col = 0; col < books[row].length; col++) {
        BookDetail book = books[row][col];
        book.getBookTable();
      }
      System.out.println(
          "-------------------------------------------------------------------------------------------");
    }
  }

  public void borrowBook(BookDatabase bookDB, String bookID) {
    BookDetail[][] books = bookDB.getBooks();
    for (int i = 0; i < books.length; i++) {
      BookDetail[] bookRow = books[i];
      for (int j = 0; j < bookRow.length; j++) {
        BookDetail book = bookRow[j];
        if (book.getBookID().equals(bookID)) {
          if (book.borrowBook()) {
            totalBooksBorrowed++;
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
    System.out.println("Book not found.");
  }

  public void returnBook(BookDatabase bookDB, String bookID) {
    BookDetail[][] books = bookDB.getBooks();
    for (int i = 0; i < books.length; i++) {
      BookDetail[] bookRow = books[i];
      for (int j = 0; j < bookRow.length; j++) {
        BookDetail book = bookRow[j];
        if (book.getBookID().equals(bookID)) {
          totalBooksBorrowed--;
          book.returnBook();
          System.out.printf(
              "Book ID: %s | Title: %s \nStatus: has been returned.\n",
              bookID, book.getBookTitle());
          return;
        }
      }
    }
    System.out.println("Book not found.");
  }

  // Static method to get the total number of books borrowed
  public static int getTotalBooksBorrowed() {
    return totalBooksBorrowed;
  }
}
