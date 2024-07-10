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

    public Author getAuthor() {
        return author;
    }

    public String getBN(){
        return BN;
    }

    /**
     * checks if the book has the same values
     * @param name - the name of the book
     * @param genre - the genre of the book
     * @param authorName - the name of the book's author
     * @param biography - the author's biography
     * @return - true/false if the the book has the same values
     */
    public boolean compare(String name, Genre genre, String authorName, String biography){
        Author author = new Author(authorName, biography);
        return (this.name.equals(name)) && (this.genre == genre) && (this.author.compare(author));
    }

    @Override
    public boolean equals(Object obj) {
        Book book = (Book)obj;
        return (this.name.equals(book.name) && (this.genre == book.genre) && (this.author.compare(book.author)));
    }

    @Override
    public String toString() {
        return "Title: " + name + ", Genre: " + genre + ", Author: " + author.toString() + ".";
    }
}
