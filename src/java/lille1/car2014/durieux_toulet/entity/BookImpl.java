package lille1.car2014.durieux_toulet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * is a book defined by a title, an auhor, a year and a price and is stored in
 * the table WBOOK.
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "WBOOK")
@NamedQueries({
  @NamedQuery(name = "books.findByTitle", query = "SELECT b FROM BookImpl b WHERE b.title LIKE :title"),
  @NamedQuery(name = "books.getAllBooks", query = "SELECT b FROM BookImpl b"),
  @NamedQuery(name = "books.getAllAuthors", query = "SELECT distinct b.author FROM BookImpl b"),
  @NamedQuery(name = "books.findByAuthor", query = "SELECT b FROM BookImpl b WHERE b.author = :author")})
public class BookImpl implements Book, Serializable {

  @Id
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "author", nullable = false)
  private String author;
  @Column(name = "book_year", nullable = false)
  private int year;

  @Column(name = "price")
  private double price;

  public BookImpl() {

  }

  public BookImpl(String title, String author, int year, double price) {
    this.title = title;
    this.author = author;
    this.year = year;
    this.price = price;
  }

  /**
   * @see Book
   */
  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @see Book
   */
  @Override
  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * @see Book
   */
  @Override
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  /**
   * @see Book
   */
  @Override
  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return title + " " + price + "€ " + author + " (" + year + ")";
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final BookImpl other = (BookImpl) obj;
    if ((this.title == null) ? (other.title != null) : !this.title.equals(other.title)) {
      return false;
    }
    return true;
  }

}
