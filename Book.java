public class Book {
    private String title;
    private String author;
    private boolean isCheckedOut = false;
    private String borrower = null;
    private LocalDate dueDate = null;

    public Book(String title, String author) {
        try {
            this.title = title;
            this.author = author;
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: your mistake was " + e.getMessage());
        }

    }

    public boolean checkOut(String studentName) {
        if (isCheckedOut()) {
            try {throw new IllegalStateException();}

            catch (IllegalStateException e) {
                System.out.println("ERROR: you have encountered " + e.getMessage());
            }
        }

        try {
            setCheckedOut(true);
            setBorrower(studentName);
            //setDueDate();
        } catch (IllegalArgumentException e) {
            System.out.println("You have encountered " + e.getMessage());
        }

        System.out.println("Checkout state: ");
        return true;

    }

    public void turnIn() {
        if (isCheckedOut()) {
            try{throw new IllegalStateException();}

            catch (IllegalArgumentException e) {
                System.out.println("You have encountered " + e.getMessage());
            }
        }

        setCheckedOut(false);
        setBorrower(null);
        setDueDate(null);

    }

    public String toString() {
        return ();
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
