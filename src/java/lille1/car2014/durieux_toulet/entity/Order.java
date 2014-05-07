package lille1.car2014.durieux_toulet.entity;

import java.util.Map;

/**
 * is an order of book.
 *
 * @author Thomas Durieux
 */
public interface Order {

  /**
   * get the order id
   *
   * @return the id
   */
  int getId();

  /**
   * get ordered books with thier qnantity
   *
   * @return ordered books with thier qnantity
   */
  Map<Book, Integer> getBooks();

  /**
   * Add a book to the order
   *
   * @param book     the book to add
   * @param quantity the qnatity
   */
  void addBook(Book book, int quantity);

  /**
   * Change the quantity of book ordered
   *
   * @param book     the book
   * @param quantity the new quantity
   */
  void editBookQuantity(Book book, int quantity);

  /**
   * remove a book
   *
   * @param book the book to remove
   */
  void removeBook(Book book);
}
