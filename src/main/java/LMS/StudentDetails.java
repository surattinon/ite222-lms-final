package LMS;

public class StudentDetails {
    private String studentID;
    private String studentName;
    private String burrowDate;
    private boolean isReturn;
    private String bookID;

    public StudentDetails(String studentID, String studentName, String burrowDate, String bookID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.burrowDate = burrowDate;
        this.bookID = bookID;
        isReturn = false;
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

    public boolean getReturnDate() {
        return isReturn;
    }

    public String getBookID() {
        return bookID;
    }

    public String isReturn() {
        if (isReturn) {
            return "Yes";
        } else {
            return "No";
        }
    }

    public void showStudent() {
        System.out.printf(
                "| %-10s| %-20s| %-20s| %-20s| %-10s|\n",
                bookID, studentID, studentName, burrowDate, isReturn());
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
