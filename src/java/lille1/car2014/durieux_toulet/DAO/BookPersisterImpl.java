package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 * used to execute all persisten operations on a book (create, edit, remove)
 *
 * @author Thomas Durieux
 */
public class BookPersisterImpl extends DAOAbs implements BookPersister {

  /**
   * @see BookPersister
   */
  @Override
  public void editBook(Book newBook, Book oldBook) {
    try {
      em.getTransaction().begin();
      em.merge(newBook);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

  /**
   * @see BookPersister
   */
  @Override
  public void removeBook(Book book) {
    try {
      em.getTransaction().begin();
      em.remove((BookImpl) book);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

  /**
   * @see BookPersister
   */
  @Override
  public void createBook(Book book) {
    try {
      em.getTransaction().begin();
      em.persist((BookImpl) book);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

}
