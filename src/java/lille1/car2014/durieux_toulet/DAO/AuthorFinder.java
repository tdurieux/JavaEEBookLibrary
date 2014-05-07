package lille1.car2014.durieux_toulet.DAO;

import java.util.List;

/**
 * is a DAO used to find author of books
 *
 * @author Thomas Durieux
 */
public interface AuthorFinder {

  AuthorFinder INSTANCE = new AuthorFinderImpl();

  /**
   * List all Authors
   *
   * @return list of author
   */
  List<String> getAllAuthors();
}
