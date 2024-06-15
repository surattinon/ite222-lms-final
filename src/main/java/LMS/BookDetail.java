package LMS;

public class BookDetail {
  private String bookID;
  private String bookTitle;
  private String bookAuthor;
  private String bookPublication;
  private boolean isAvailable;
  private String status = "Available";

  public BookDetail(String bookID, String title, String author, String publication) {
    this.bookTitle = title;
    this.bookAuthor = author;
    this.bookPublication = publication;
    this.bookID = bookID;
    this.isAvailable = true;
  }

  // boolean method to check if the book is available
  public boolean isNotBorrow() {
    // If the book is available, set it to false and return true
    if (isAvailable) {
      isAvailable = false;
      status = "Not Available";
      return true;
    }
    return false; // If the book is not available, return false
  }

  // Method to return the book by setting isAvailable to true
  public void returnBook() {
    isAvailable = true;
    status = "Available";
  }

  // Getter method for bookID
  public String getBookID() {
    return bookID;
  }

  // Getter method for bookTitle
  public String getBookTitle() {
    return bookTitle;
  }

  // Getter method for print books details in table format
  public void getBookTable() {
    System.out.printf(
        "| %-10s| %-20s| %-20s| %-20s| %-20s|\n",
        bookID, bookTitle, bookAuthor, bookPublication, status);
  }
}
