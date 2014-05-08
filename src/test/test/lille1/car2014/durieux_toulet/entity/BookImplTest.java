package test.lille1.car2014.durieux_toulet.entity;

import lille1.car2014.durieux_toulet.entity.BookImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BookImplTest {

  @Test
  public void testBookConstructorWithoutParameters() {
    // Instanciate book
    BookImpl book = new BookImpl();

    // Test construction
    assertEquals(null, book.getTitle());
    assertEquals(null, book.getAuthor());
    assertEquals(0, book.getYear());
    assertEquals(0.0, book.getPrice(), 0);
  }

  @Test
  public void testBookConstructorWithParameters() {
    // Book data
    String title = "Game_of_thrones";
    String author = "Hodor";
    int year = 2013;
    double price = 20.50;

    // Instanciate book
    BookImpl book = new BookImpl(title, author, year, price);

    // Test construction
    assertEquals(title, book.getTitle());
    assertEquals(author, book.getAuthor());
    assertEquals(year, book.getYear());
    assertEquals(price, book.getPrice(), 0.01);
  }

}
