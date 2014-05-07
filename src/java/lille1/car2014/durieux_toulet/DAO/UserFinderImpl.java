package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lille1.car2014.durieux_toulet.entity.User;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 * is a DAO used to find user
 *
 * @author Thomas Durieux
 */
class UserFinderImpl extends DAOAbs implements UserFinder {

  public UserFinderImpl() {
    initUserDB();
  }

  /**
   * @see UserFinder
   */
  @Override
  public User getUser(int id) {
    return em.find(UserImpl.class, id);
  }

  /**
   * @see UserFinder
   */
  @Override
  public User getUserFromUsername(String username) {
    return (User) em.createNamedQuery("User.findByUsername").
            setParameter("username", username).getSingleResult();
  }

  /**
   * @see UserFinder
   */
  @Override
  public List<User> getAllUsers() {
    return (List<User>) em.createNamedQuery("User.all").getResultList();
  }

  /**
   * Init the admin db
   */
  private void initUserDB() {
    try {
      User u = new UserImpl("admin", "admin", "admin", "admin");
      UserPersister.INSTANCE.createUser(u);
    } catch (Exception e) {
      Logger.getLogger(this.getClass().getName()).log(
              Level.SEVERE, null, e);
      // if an error occurs during initialization, it just does not initialize the DB.
    }
  }
}
