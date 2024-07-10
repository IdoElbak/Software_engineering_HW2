public class Author {
    private String name;
    private String biography;

    public Author(String name, String biography){
        this.name = name;
        this.biography = biography;
    }

    public boolean compare(Author author){
        return (this.name.equals(author.name)) && (this.biography.equals(author.biography));
    }

    @Override
    public String toString() {
        return name;
    }
}
