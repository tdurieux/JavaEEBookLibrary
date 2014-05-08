package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.BookManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class BookManagerTest {

    @Test
    public void testBookCreation() {
        BookManager bm = new BookManager();

        bm.setBookTitle("Game of thrones");
        bm.setBookAuthor("Hodor");
        bm.setBookYear(2013);
        bm.setBookPrice(20.50);

        bm.createBook();

        //assertEquals(?, ?);
    }

}
