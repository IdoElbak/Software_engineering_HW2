public class Library {
    private String name;
    private Book[] books;
    private Member[] members;
    private Author[] booksAuthors;

    public Library(String name){
        this.name = name;
        this.books = new Book[20];
        this.members = new Member[5];
        this.booksAuthors = new Author[20];
    }

    /*
     * public void addBook(String name, Genre genre, String authorName, String biography)
     */
}
