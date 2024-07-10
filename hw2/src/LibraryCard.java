public class LibraryCard {
    private String cardId;
    private int maxNumberOfBooks;

    public LibraryCard(String cardId, int maxNumberOfBooks){
        this.cardId = cardId;
        this.maxNumberOfBooks = maxNumberOfBooks;
    }

    public int GetMaxNumberOfBooks(){
        return this.maxNumberOfBooks;
    }
}
