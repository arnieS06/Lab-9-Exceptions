import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut = false;
    private String borrower = null;
    private LocalDate dueDate = null;

    public Book(String title, String author) {
        if (title == null || title.isEmpty() || author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Title or author cannot be null or empty");
        }
        this.title = title;
        this.author = author;
    }

    public boolean checkOut(String studentName) {
        if (isCheckedOut()) {
            throw new IllegalStateException("Book is already checked out");
        }

        if (studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("Student name cannot be null or empty");
        }

        setCheckedOut(true);
        setBorrower(studentName);
        setDueDate(LocalDate.now().plusDays(14));

        System.out.println("Checkout state: ");
        return true;
    }

    public void turnIn() {
        if (!isCheckedOut()) {
            throw new IllegalStateException("Book is not checked out");
        }

        setCheckedOut(false);
        setBorrower(null);
        setDueDate(null);
    }

    public String toString() {
        String checkedOut = "No";

        if (isCheckedOut()) {
            checkedOut = "Yes";
        }

        return (getTitle() + ", " + getAuthor() + ", Checked out: " + checkedOut);
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean isCheckedOut) {
        this.isCheckedOut = isCheckedOut;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
