public class Library {
    private Book[] books;
    private int bookCount;
    private final int MAX_BOOKS = 1000;

    public Library() {
        this.books = new Book[MAX_BOOKS];

    }

    public int getBookCount() {
        return bookCount;
    }

    public int getMAX_BOOKS() {
        return MAX_BOOKS;
    }


}