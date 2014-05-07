package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Book;

/**
 * used to execute all persisten operations on a book (create, edit, remove)
 *
 * @author Thomas Durieux
 */
public interface BookPersister {

  BookPersister INSTANCE = new BookPersisterImpl();

  /**
   * Edit a existing book
   *
   * @param newBook the new version of the book
   * @param oldBook the current version of the book
   */
  void editBook(Book newBook, Book oldBook);

  /**
   * Remove a book
   *
   * @param book to remove
   */
  void removeBook(Book book);

  /**
   * Store the book to the persister
   *
   * @param book to store
   */
  void createBook(Book book);
}
