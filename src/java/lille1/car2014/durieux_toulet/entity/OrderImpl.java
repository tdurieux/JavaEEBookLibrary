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
import javax.persistence.Table;

/**
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "ORDERS")
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

  @Override
  public int getId() {
    return id;
  }

  @Override
  public Map<Book, Integer> getBooks() {
    return books;
  }

  @Override
  public void addBook(Book book, int quantity) {
    books.put(book, quantity);
  }

  @Override
  public void editBookQuantity(Book book, int quantity) {
    books.remove(book);
    books.put(book, quantity);
  }

  @Override
  public void removeBook(Book book) {
    books.remove(book);
  }

}
