public class Member {
    private String name;
    private LibraryCard libraryCard;
    private Book[] borrowedBooks;

    public Member(String name, LibraryCard libraryCard){
        this.name = name;
        this.libraryCard = libraryCard;
        borrowedBooks = new Book[libraryCard.GetMaxNumberOfBooks()];
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Checked-out books: \n" + ListOfBooks();
    }

    private String ListOfBooks(){
        String res = "";
        if(borrowedBooks[0] == null){
            return "";
        }
        for(int i = 0; i < borrowedBooks.length && borrowedBooks[i] != null; i++){
            res += borrowedBooks[i].toString() + "\n";
        }
        return res;
    }
}
