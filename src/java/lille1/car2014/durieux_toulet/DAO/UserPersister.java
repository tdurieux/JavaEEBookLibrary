package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.User;

/**
 * used to execute all persisten operations on a user (create, edit, remove)
 *
 * @author Thomas Durieux
 */
public interface UserPersister {

  UserPersister INSTANCE = new UserPersisterImpl();

  /**
   * Create a new user
   *
   * @param user the new user
   */
  void createUser(User user);

  /**
   * Remove a user
   *
   * @param user the user to remove
   */
  void removeUser(User user);

  /**
   * Edit user information
   *
   * @param newUser the new user information
   * @param oldUser the old user information
   */
  void editUser(User newUser, User oldUser);
}
