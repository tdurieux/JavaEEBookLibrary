package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.User;

/**
 * is a DAO used to find user
 *
 * @author Thomas Durieux
 */
public interface UserFinder {

  UserFinder INSTANCE = new UserFinderImpl();

  /**
   * Get an user from its id
   *
   * @param id the user id
   *
   * @return the user
   */
  User getUser(int id);

  /**
   * Get an user from its username
   *
   * @param username
   *
   * @return the user
   */
  User getUserFromUsername(String username);

  /**
   * List all users
   *
   * @return all users
   */
  List<User> getAllUsers();
}
