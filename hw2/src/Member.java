public class Member {
    private String name;
    private LibraryCard libraryCard;
    private Book[] borrowedBooks;

    public Member(String name, LibraryCard libraryCard){
        this.name = name;
        this.libraryCard = libraryCard;
        borrowedBooks = new Book[libraryCard.GetMaxNumberOfBooks()];
    }

    /**
     * function gets a book and check if the user is borrowing it
     * @param compareBook - the book
     * @return true/false is the member is indeed borrowing the book
     */
    public boolean isBorrowingBook(Book compareBook){
        for(Book book : borrowedBooks){
            if(book.equals(compareBook)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + this.name + ", Checked-out books: \n" + ListOfBooks();
    }

    /**
     *
     * @return a string holding all books the member borrowed
     */
    private String ListOfBooks(){
        String res = "";
        for (Book borrowedBook : borrowedBooks) {
            if (borrowedBook != null) {
                res += borrowedBook.toString() + "\n";
            }
        }
        return res;
    }
}
