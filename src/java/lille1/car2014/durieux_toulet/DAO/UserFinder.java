package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.User;

/**
 *
 * @author Thomas Durieux
 */
public interface UserFinder {

  UserFinder INSTANCE = new UserFinderImpl();

  User getUser(int id);

  User getUserFromUsername(String username);

  List<User> getAllUsers();
}
