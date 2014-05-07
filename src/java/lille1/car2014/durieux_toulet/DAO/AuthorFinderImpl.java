package lille1.car2014.durieux_toulet.DAO;

import java.util.List;

/**
 * is a DAO used to find author of books
 *
 * @author Thomas Durieux
 */
class AuthorFinderImpl extends DAOAbs implements AuthorFinder {

  /**
   * @see AuthorFinder
   */
  @Override
  public List<String> getAllAuthors() {
    return (List<String>) em.createNamedQuery("books.getAllAuthors").getResultList();
  }

}
