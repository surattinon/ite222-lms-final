package LMS;

public class StudentDetails {
    private String studentID;
    private String studentName;
    private String burrowDate;
    private boolean isReturn;
    private String bookID;

    String Returned = "N/A";

    public StudentDetails(String studentID, String studentName, String burrowDate, String bookID) {

        this.studentID = studentID;
        this.studentName = studentName;
        this.burrowDate = burrowDate;
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
        return burrowDate;
    }

    public boolean getReturn() {
        return isReturn;
    }

    public String getBookID() {
        return bookID;
    }

    public void isReturn() {
        if (isReturn) {
            Returned = "Yes";
        } else {
            Returned = "No";
        }
    }

    public void setBookID(String bookID, String borrowedDate) {
        this.bookID = bookID;
        this.burrowDate = borrowedDate;

    }

    public void showStudent() {
        System.out.printf(
                "| %-10s| %-20s| %-20s| %-20s| %-10s|\n",
                studentID, studentName, bookID, burrowDate, Returned);
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
