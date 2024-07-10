import java.util.concurrent.RecursiveTask;

public class Library {
    private String name;
    private Book[] books;
    private int nextBN;
    private int nextLC;
    private Member[] members;

    public Library(String name){
        this.name = name;
        this.books = new Book[20];
        this.members = new Member[5];
        nextBN = 0;
        nextLC = 0;
    }

    /**
     * this function gets data about the new book and will add it to the library
     * unless the book is already registered or the limit number of books was reached
     * the function gets the BN from nextBN.
     * (assume always a new book)
     * the function checks if the specific author already wrote a book that is in the library
     *   -- in case he did, the function adds the book with the already existing author object
     *   -- else, the function makes a new author and uses it to add the book
     *
     * @param name - the name of the book
     * @param genre - the genre of the book
     * @param authorName,biography - the name of the author and his biography
     */
     public void addBook(String name, Genre genre, String authorName, String biography){
        int i = findNextEmptySlot();
        if(i == -1){
            System.out.println("Library is full, cannot add more books.");
            return;
        }
        Author author = new Author(authorName,biography);
        for(Book book : books){
            if(book != null && getAuthor(book.getBN()).compare(author)){
                //the if can be way less complicated but have to use getAuthor(BN)....
                books[i] = new Book(name, genre, book.getAuthor(), "BN" + nextBN);
                nextBN++;
                return;
            }
        }
        books[i] = new Book(name, genre, author, "BN" + nextBN);
        nextBN++;
     }

    /**
     * @return the index of the next free slot
     */
     private int findNextEmptySlot(){
         for(int i = 0; i < books.length; i++) {
             if(books[i] == null){
                 return i;
             }
         }
         return -1;
     }

    /**
     * this function gets data about a book and removes it from the library
     * unless the book doesn't exist or is being borrowed
     * @param name - the name of the book
     * @param genre - the book's genre
     * @param authorName - the name of the author of the book
     * @param biography - the author's biography
     */
     public void removeBook(String name, Genre genre, String authorName, String biography){
         for(int i = 0; i < books.length; i++){
             if(books[i] != null && books[i].compare(name, genre, authorName, biography)){
                 if(isBookBorrowed(books[i])){
                     System.out.println("No such book exists.");
                 }else {
                     books[i] = null;
                 }
                 return;
             }
         }
         System.out.println("No such book exists.");
     }

    /**
     * this function goes through each book checking if it's borrowed and if it doesn't it prints data about it
     */
    public void printBooks(){
         boolean flag = false;
         for(Book book : books){
            if(book == null){
                continue;
            }
            if(!isBookBorrowed(book)){// if the book is NOT being borrowed print it
                flag = true;
                System.out.println(book);
            }
         }
         if(!flag){
             System.out.println("No books in the library currently.");
         }
     }

    /**
     * this function checks if a certain book is being borrowed at the moment
     * @param book - a book type object
     * @return is that book currently being borrowed
     */
     private boolean isBookBorrowed(Book book){
         for(Member member : members){
             if(member != null && member.isBorrowingBook(book)){
                 return true;
             }
         }
         return false;
     }

    /**
     * this function gets data related to a new member and tries to add it
     * @param name - the name of the member
     * @param maxCheckouts - the max number of books he can borrow
     */
     public void addMember(String name, int maxCheckouts){
         LibraryCard libCard = new LibraryCard("LC" + nextLC++,maxCheckouts);
         for(int i = 0; i < members.length; i++){
             if(members[i] == null){
                 members[i] = new Member(name,libCard);
                 return;
             }
         }
         System.out.println("Library is full, cannot add more members.");
     }

    /**
     * this function get BN and find the relative book to return its author
     * @param BN - the id of a book
     * @return author type object
     */
     public Author getAuthor(String BN) {
         for(Book book : books){
             if(book != null && book.getBN().equals(BN)){
                 return book.getAuthor();
             }
         }
         return null;
     }


    public void removeMember(String LC){
         // to be done
    }

    public void printMember(String LC){
         // to be done
    }

    public void checkOutBook(String BN, String LC){
         // to be done
    }

    public void returnBook(String BN, String LC){
        // to be done
    }


}
