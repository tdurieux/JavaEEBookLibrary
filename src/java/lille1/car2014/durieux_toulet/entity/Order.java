package lille1.car2014.durieux_toulet.entity;

import java.util.Map;

/**
 *
 * @author Thomas Durieux
 */
public interface Order {

  int getId();

  Map<Book, Integer> getBooks();

  void addBook(Book book, int quantity);

  void editBookQuantity(Book book, int quantity);

  void removeBook(Book book);
}
