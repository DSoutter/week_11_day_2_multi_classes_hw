import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;
    private Borrower borrower;

    @Before
    public void before(){
        library = new Library(5);
        book = new Book("1984","George Orwell","Dystopian");
        borrower = new Borrower("Steve", 2);
    }

    @Test
    public void hasCapacity(){
        assertEquals(5, library.getCapacity());
    }

    @Test
    public void hasBooksInStock(){
        library.addBook(book);
        assertEquals(1,library.countStock());
    }

    @Test
    public void checkRemoveBook(){
        library.addBook(book);
        library.addBook(book);
        library.removeBook();
        assertEquals(1,library.countStock());

    }

    @Test
    public void checkRentalTransactionPasses(){
        library.addBook(book);
        library.checkOutBook(borrower);
        assertEquals(0, library.countStock());
        assertEquals(1, borrower.countStock());
    }

    @Test
    public void checkRentalTransactionFails(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        library.checkOutBook(borrower);
        library.checkOutBook(borrower);
        library.checkOutBook(borrower);
        assertEquals(1, library.countStock());
        assertEquals(2, borrower.countStock());
    }

    @Test
    public void checkNumberOfDystopianBooks(){
        library.addBook(book);
        library.addBook(book);
        library.addBook(book);
        assertEquals(2, library.getBooksByGenre("Dystopian"));
    }
}
