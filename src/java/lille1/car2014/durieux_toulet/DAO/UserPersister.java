package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 *
 * @author Thomas Durieux
 */
public interface UserPersister {

  UserPersister INSTANCE = new UserPersisterImpl();

  void createUser(UserImpl user);

  void removeUser(UserImpl user);

  void editUser(UserImpl newUser, UserImpl oldUser);
}
