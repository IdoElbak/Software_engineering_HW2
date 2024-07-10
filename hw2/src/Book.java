public class Book {
    private String name;
    private Genre genre;
    private Author author;
    private String BN;

    public Book(String name, Genre genre, Author author, String BN){
        this.name = name;
        this.genre = genre;
        this.author = author;
        this.BN = BN;
    }

    @Override
    public String toString() {
        return "Title: " + name + ", Genre: " + genre + ", Author: " + author.toString() + ".";
    }
}
