public class Library {
    private Book[] books;
    private int bookCount;
    private final int MAX_BOOKS = 1000;

    public int getBooksIndex() {
        for (int n = 0; n < books.length; n++) {
            if (books[n] == null) {
                return n;
            }
        }
        return MAX_BOOKS - 1;
    }

    public boolean containsBook(Book b) {
        for (int n = 0; n < this.books.length; n++) {
            if (this.books[n].getAuthor().equals(b.getAuthor()) && this.books[n].getTitle().equals(b.getTitle())) {
                return true;
            }
        }
        return false;
    }

    public Library() {
        this.books = new Book[MAX_BOOKS];
    }

    public void addBook(Book b) {
        try {
            if (this.books.length > MAX_BOOKS) {
                throw new IllegalStateException();
            }

            else if (containsBook(b)) {
                throw new IllegalStateException();
            }

            else if (this.books[0] == null) {
                this.books[0] = b;

            }

            books[getBooksIndex()] = b;

            this.bookCount++;

        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }


}
