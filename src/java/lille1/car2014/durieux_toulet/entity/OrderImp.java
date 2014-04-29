package lille1.car2014.durieux_toulet.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "orders")
public class OrderImp {

  @Id
  private int id;

  @OneToMany
  private List<BookImp> books;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<BookImp> getBooks() {
    return books;
  }

  public void setBooks(List<BookImp> books) {
    this.books = books;
  }

}
