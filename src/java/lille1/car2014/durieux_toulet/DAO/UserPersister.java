package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.User;

/**
 *
 * @author Thomas Durieux
 */
public interface UserPersister {

  UserPersister INSTANCE = new UserPersisterImpl();

  void createUser(User user);

  void removeUser(User user);

  void editUser(User newUser, User oldUser);
}
