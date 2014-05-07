package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 * is a DAO used to find book
 *
 * @author Thomas Durieux
 */
public class BookFinderImpl extends DAOAbs implements BookFinder {

  public BookFinderImpl() {
    initBookDB();
  }

  /**
   *
   * @see BookFinder
   */
  @Override
  public List<Book> getAllBooks() {
    return (List<Book>) em.createNamedQuery("books.getAllBooks").getResultList();
  }

  /**
   *
   * @see BookFinder
   */
  @Override
  public List<Book> findBooks(String title) {
    return (List<Book>) em.createNamedQuery("books.findByTitle").setParameter("title", "%" + title + "%").getResultList();
  }

  /**
   *
   * @see BookFinder
   */
  @Override
  public List<Book> getBookFromAuthor(String author) {
    return (List<Book>) em.createNamedQuery("books.findByAuthor").setParameter("author", author).getResultList();
  }

  /**
   *
   * @see BookFinder
   */
  @Override
  public Book getBook(String title) {
    return em.find(BookImpl.class, title);
  }

  /**
   * Function used to initiate book DB
   */
  private void initBookDB() {
    try {
      Book book = new BookImpl("RMI", "Info", 1990, 9.87);
      BookPersister.INSTANCE.createBook(book);
      book = new BookImpl("JavaEE", "Info", 1920, 5.87);
      BookPersister.INSTANCE.createBook(book);
      book = new BookImpl("Rest", "Info", 1910, 3.87);
      BookPersister.INSTANCE.createBook(book);

      book = new BookImpl("Bible", "Eglise", 0, 20.0);
      BookPersister.INSTANCE.createBook(book);
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(
              Level.SEVERE, null, e);
      // if an error occurs during initialization, it just does not initialize the DB.
    }
  }
}
