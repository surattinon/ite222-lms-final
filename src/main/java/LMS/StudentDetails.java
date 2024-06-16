package LMS;

public class StudentDetails {
    private String studentID;
    private String studentName;
    private String borrowDate;
    private boolean isReturn;
    private String bookID;

    String Returned = "";

    public StudentDetails(String studentID, String studentName, String borrowDate, String bookID) {

        this.studentID = studentID;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.bookID = bookID;
        this.isReturn = false;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getBurrowDate() {
        return borrowDate;
    }

    public boolean getReturn() {
        return isReturn;
    }

    public String getBookID() {
        return bookID;
    }

    public void isReturn() {
        if (isReturn) {
            isReturn = false;
            Returned = "Yes";
        } else {
            isReturn = true;
            Returned = "No";
        }
    }

    public void setBookID(String bookID, String borrowedDate) {
        this.bookID = bookID;
        this.borrowDate = borrowedDate;

    }

    public void showStudent() {
        System.out.printf(
                "| %-20s| %-20s| %-20s| %-20s| %-10s|\n",
                studentID, studentName, bookID, borrowDate, Returned);
    }
}

class StudentDB {
    private StudentDetails[] students;

    public StudentDB(StudentDetails[] students) {
        this.students = students;
    }

    public void setStudentDB(StudentDetails[] students) {
        this.students = students;
    }

    public StudentDetails[] getStudentDB() {
        return students;
    }

}
