package LMS;

/** Librarian */
public class Librarian {
  // Fields
  private int id;
  private String password;
  private boolean isError;
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

    // Declare books as datatype BookDetail array and store the array of books from the BookDatabase
    BookDetail[] books = bookDB.getBookDB();
    System.out.println(
        "-----------------------------------------------------------------------------------------------------");
    System.out.printf(
        "| %-10s| %-20s| %-20s| %-20s| %-20s|\n", "ID", "Title", "Author", "Publication", "Status");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------");
    for (BookDetail book : books) { // ForEach loop through the array of books
      // Call the getBookTable method to print book details by index
      book.showBookTable();
    }
    System.out.println(
        "-----------------------------------------------------------------------------------------------------");
  }

  public void showStudent(StudentDatabase studentDB) {

    // Declare students as datatype StudentDetails array and store the array of students from the
    // StudentDatabase
    StudentDetail[] students = studentDB.getStudentDB();
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------");
    System.out.printf(
        "| %-20s| %-20s| %-20s| %-20s| %-10s| %-10s|\n",
        "Student ID", "Name", "Book ID", "Borrow Date", "Returned", "Due Date");
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------");
    for (StudentDetail student : students) { // ForEach loop through the array of students

      // Call the showStudentTable method to print student details by index
      student.showStudentTable();
    }
    System.out.println(
        "-----------------------------------------------------------------------------------------------------------------");
  }

  // Method to borrow a book by ID and student ID
  public void borrowBook(
      BookDatabase bookDB,
      StudentDatabase studentDB,
      String bookID,
      String studentID,
      String borrowDate) {
    // Declare books as datatype BookDetail array and store the array from the BookDatabase
    BookDetail[] books = bookDB.getBookDB();
    // Declare students as datatype StudentDetails array and store the array from StudentDatabase
    StudentDetail[] students = studentDB.getStudentDB();

    // ForEach loop through the array of books
    for (BookDetail book : books) {
      // ForEach loop through the array of students
      for (StudentDetail student : students) {
        if (book.getBookBorrowID().equals(bookID) // Check if the book ID matches the input
            && student
                .getStudentID()
                .equals(studentID)) { // Check if the student ID matches the input

          // Check if the book is available by calling the isNotBorrow method
          if (book.isNotBorrow()) {
            totalBooksBorrowed++; // Increment the total books borrowed
            System.out.printf("\nStatus:\nBook ID %s.\nTitle %s.\n", bookID, book.getBookTitle());
            student.setBookBorrowID(bookID, borrowDate);
            System.out.printf("Borrowed by %s\n", student.getStudentName());
            student.toggleReturn(); // Call the toggleReturn method to toggle the return status
            return; // finish the method
          } else {
            System.out.println("The book is not available for borrowing.");
            return; // finish the method
          }
        } else {
          isError = true;
        }
      }
    }
    if (isError) { // If isError is true
      System.out.println("Invalid BookID or Student ID");
    }
  }

  // Method to return a book by book ID
  public void returnBook(BookDatabase bookDB, String bookID, StudentDatabase studentDB) {
    // Declare books as datatype BookDetail array and store the array from the BookDatabase
    BookDetail[] books = bookDB.getBookDB();

    // Declare students as datatype StudentDetails array and store the array from the
    // StudentDatabase
    StudentDetail[] students = studentDB.getStudentDB();

    // ForEach loop through the array of books
    for (BookDetail book : books) {
      // ForEach loop through the array of students
      for (StudentDetail student : students) {
        if (student.getBookBorrowID().equals(bookID)
            && book.getBookBorrowID().equals(bookID)) { // Check if the book ID matches the input
          if (book.isNotReturn()) {
            totalBooksBorrowed--; // Decrement the total books borrowed
            System.out.printf("\nStatus:\nBook ID %s.\nTitle %s.\n", bookID, book.getBookTitle());
            System.out.printf("Returned by %s\n", student.getStudentName());
            student.toggleReturn(); // Call the toggleReturn method to toggle the return status
            return; // finish the method
          } 
        } else {
          isError = true;
        }
      }
    }
    if (isError) {
      System.out.println("Invalid BookID");
    }
  }

  // Static method to get the total number of books borrowed
  public static int getTotalBooksBorrowed() {
    return totalBooksBorrowed;
  }
}
