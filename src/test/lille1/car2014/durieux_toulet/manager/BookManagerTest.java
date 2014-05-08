package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.BookManager;
import lille1.car2014.durieux_toulet.DAO.BookFinder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class BookManagerTest {

    @Test
    public void testBookCreation() {
        // Instanciate book manager
        BookManager bm = new BookManager();

        // Book data
        String title = "Game_of_thrones";
        String author = "Hodor";
        int year = 2013;
        double price = 20.50;

        // Set book data
        bm.setBookTitle(title);
        bm.setBookAuthor(author);
        bm.setBookYear(year);
        bm.setBookPrice(price);

        // Create book
        bm.createBook();

        // Do tests
        assertEquals(title, BookFinder.INSTANCE.getBook(title).getTitle())
        assertEquals(author, BookFinder.INSTANCE.getBook(title).getAuthor())
        assertEquals(year, BookFinder.INSTANCE.getBook(title).getYear())
        assertEquals(price, BookFinder.INSTANCE.getBook(title).getPrice())
    }

}
