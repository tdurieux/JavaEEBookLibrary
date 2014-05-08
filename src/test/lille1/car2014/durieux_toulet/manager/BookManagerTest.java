package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.BookManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class BookManagerTest {

    @Test
    public void testBookCreation() {
        // Instanciate book manager
        BookManager bm = new BookManager();

        // Set book data
        bm.setBookTitle("Game_of_thrones");
        bm.setBookAuthor("Hodor");
        bm.setBookYear(2013);
        bm.setBookPrice(20.50);

        // Create book
        bm.createBook();

        //assertEquals(?, ?);
    }

}
