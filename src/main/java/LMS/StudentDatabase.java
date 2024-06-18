package LMS;

public class StudentDatabase {

  // Fields
  // Declare students as a private field with datatype StudentDetails array
  private StudentDetail[] students;

  // Constructor for StudentDatabase class
  public StudentDatabase(StudentDetail[] students) {
    this.students = students;
  }

  // Getter method for students field
  public StudentDetail[] getStudentDB() {
    return students;
  }
}

// Subclass StudentDetails
class StudentDetail {
  // Fields
  private String studentID;
  private String studentName;
  private String borrowDate;
  private String bookID;
  private String returnStatus;
  private boolean isReturn;
  private String dueDate;

  // Constructor for StudentDetails class
  public StudentDetail(String studentID, String studentName, String borrowDate, String bookID) {
    this.studentID = studentID;
    this.studentName = studentName;
    this.borrowDate = borrowDate;
    this.bookID = bookID;
    this.returnStatus = ""; // Set returnStatus to an empty string by default
    this.dueDate = ""; // Set dueDate to an empty string by default
  }

  // Setter method for bookBorrowID
  public void setBookBorrowID(String bookID, String borrowedDate) {
    this.bookID = bookID;
    this.borrowDate = borrowedDate;
  }

  // Getter method for studentID
  public String getStudentID() {
    return studentID;
  }

  // Getter method for studentName
  public String getStudentName() {
    return studentName;
  }

  // Getter method for bookID
  public String getBookBorrowID() {
    return bookID;
  }

  // toggleReturn method to toggle the return status
  public void toggleReturn() {
    if (isReturn) { // if isReturn is true
      isReturn = false; // Set isReturn to false
      returnStatus = "Yes"; // Set returnStatus to "Yes"
      dueDate = "";
    } else {
      isReturn = true; // Set isReturn to true
      returnStatus = "No"; // Set returnStatus to "No"
      dueDate = "7 days"; // Set dueDate to "7 days"
    }
  }

  // Method to show the student as a table format with printf
  public void showStudentTable() {
    System.out.printf(
        "| %-20s| %-20s| %-20s| %-20s| %-10s| %-10s|\n",
        studentID, studentName, bookID, borrowDate, returnStatus, dueDate);
  }
}
