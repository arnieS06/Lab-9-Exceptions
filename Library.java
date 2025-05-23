import java.time.LocalDate;

public class Library {
    private Book[] books;
    private int bookCount;
    private final int MAX_BOOKS = 1000;

    public Library() {
        this.books = new Book[MAX_BOOKS];
        this.bookCount = 0;
    }

    public int getBooksIndex() {
        for (int n = 0; n < books.length; n++) {
            if (books[n] == null) {
                return n;
            }
        }
        return MAX_BOOKS - 1;
    }

    public boolean containsBook(Book b) {
        for (int n = 0; n < bookCount; n++) {
            if (books[n] != null &&
                    books[n].getAuthor().equals(b.getAuthor()) &&
                    books[n].getTitle().equals(b.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public boolean containsBook(String title) {
        for (int n = 0; n < bookCount; n++) {
            if (books[n] != null && books[n].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public boolean isBooksFull() {
        return bookCount >= MAX_BOOKS;
    }

    public void addBook(Book b) {
        if (isBooksFull()) {
            throw new IllegalStateException("Library is full");
        }

        if (containsBook(b)) {
            throw new IllegalStateException("Book already exists in library");
        }

        books[bookCount] = b;
        bookCount++;
    }

    public void addBook(String title, String author) {
        Book b = new Book(title, author);
        addBook(b);
    }

    public Book findBook(String title) {
        for (int n = 0; n < bookCount; n++) {
            if (books[n] != null && books[n].getTitle().equals(title)) {
                return books[n];
            }
        }
        throw new IllegalArgumentException("Book not found");
    }

    public boolean checkOutBook(String title, String studentName) {
        Book book = findBook(title);
        return book.checkOut(studentName);
    }

    public boolean returnBook(String title) {
        Book book = findBook(title);

        if (!book.getIsCheckedOut()) {
            throw new IllegalStateException("Book is not checked out");
        }

        book.turnIn();
        return true;
    }

    public Book[] getBooks() {
        int numberOfValidBooks = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                numberOfValidBooks++;
            }
        }

        Book[] validBooks = new Book[numberOfValidBooks];
        int j = 0;

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                validBooks[j] = books[i];
                j++;
            }
        }

        return validBooks;
    }

    public Book[] findOverdueBooks() {
        int count = 0;

        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getIsCheckedOut() && b.getDueDate().isBefore(LocalDate.now())) {
                count++;
            }
        }

        Book[] overdueBooks = new Book[count];
        int index = 0;

        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getIsCheckedOut() && b.getDueDate().isBefore(LocalDate.now())) {
                overdueBooks[index] = b;
                index++;
            }
        }

        return overdueBooks;
    }

    public boolean checkStudentOverdue(String studentName) {
        if (studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("line 137 you entered null/empty");
        }

        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getIsCheckedOut() && studentName.equals(b.getBorrower()) && b.getDueDate().isBefore(LocalDate.now())) {
                return true;
            }
        }

        return false;
    }

    public Book[] studentBooksOverdue(String studentName) {
        if (studentName == null || studentName.isEmpty()) {
            throw new IllegalArgumentException("you entered an empty/null string.");
        }

        int count = 0;

        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getIsCheckedOut() && studentName.equals(b.getBorrower()) && b.getDueDate().isBefore(LocalDate.now())) {
                count++;
            }
        }

        Book[] overdueBooks = new Book[count];
        int index = 0;

        for (int i = 0; i < bookCount; i++) {
            Book b = books[i];
            if (b.getIsCheckedOut() && studentName.equals(b.getBorrower()) && b.getDueDate().isBefore(LocalDate.now())) {
                overdueBooks[index] = b;
                index++;
            }
        }

        return overdueBooks;
    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }

}
