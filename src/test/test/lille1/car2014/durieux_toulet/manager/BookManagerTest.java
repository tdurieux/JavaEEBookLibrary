package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.DAO.BookFinder;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.manager.BookManager;
import static org.junit.Assert.assertEquals;
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

    // Get book
    Book book = BookFinder.INSTANCE.getBook(title);

    // Do tests
    assertEquals(title, book.getTitle());
    assertEquals(author, book.getAuthor());
    assertEquals(year, book.getYear());
    assertEquals(price, book.getPrice(), 0);
  }

}
