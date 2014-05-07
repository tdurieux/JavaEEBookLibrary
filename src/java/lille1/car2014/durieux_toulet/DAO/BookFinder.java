package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.Book;

/**
 * is a DAO used to find book
 *
 * @author Thomas Durieux
 */
public interface BookFinder {

  BookFinder INSTANCE = new BookFinderImpl();

  /**
   * List all books
   *
   * @return a list of book
   */
  List<Book> getAllBooks();

  /**
   * Search books based on its title
   *
   * @param title the author
   *
   * @return a list of book
   */
  List<Book> findBooks(String title);

  /**
   * List all book of a specific author
   *
   * @param author the author
   *
   * @return a list of book
   */
  List<Book> getBookFromAuthor(String author);

  /**
   * Get a book from it title
   *
   * @param title the title
   *
   * @return a book
   */
  Book getBook(String title);
}
