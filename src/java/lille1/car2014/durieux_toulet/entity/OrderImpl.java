package lille1.car2014.durieux_toulet.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * is an entity order stored on the table ORDERS
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "ORDERS")
@NamedQueries({
  @NamedQuery(name = "order.getAllOrder", query = "SELECT b FROM OrderImpl b")})
public class OrderImpl implements Order, Serializable {

  @Id
  @GeneratedValue(generator = "increment")
  private int id;

  @ElementCollection
  @CollectionTable(name = "cartsbooks", joinColumns = @JoinColumn(name = "id"))
  @Column(name = "quantity")
  @MapKeyJoinColumn(name = "title", referencedColumnName = "title")
  private final Map<Book, Integer> books;

  public OrderImpl() {
    books = new HashMap<Book, Integer>();
  }

  /**
   *
   * @see Order
   */
  @Override
  public int getId() {
    return id;
  }

  /**
   *
   * @see Order
   */
  @Override
  public Map<Book, Integer> getBooks() {
    return books;
  }

  /**
   *
   * @see Order
   */
  @Override
  public void addBook(Book book, int quantity) {
    books.put(book, quantity);
  }

  /**
   *
   * @see Order
   */
  @Override
  public void editBookQuantity(Book book, int quantity) {
    books.remove(book);
    books.put(book, quantity);
  }

  /**
   *
   * @see Order
   */
  @Override
  public void removeBook(Book book) {
    books.remove(book);
  }

}
