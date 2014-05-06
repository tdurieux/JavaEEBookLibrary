package lille1.car2014.durieux_toulet.DAO;

import java.util.List;

/**
 *
 * @author Thomas Durieux
 */
class AuthorFinderImpl extends DAOAbs implements AuthorFinder {

  @Override
  public List<String> getAllAuthors() {
    return (List<String>) em.createNamedQuery("books.getAllAuthors").getResultList();
  }

}
