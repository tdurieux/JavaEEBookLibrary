package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 *
 * @author Thomas Durieux
 */
public interface UserFinder {

  UserFinder INSTANCE = new UserFinderImpl();

  UserImpl getUser(int id);

  UserImpl getUserFromUsername(String username);

  List<UserImpl> getAllUsers();
}
