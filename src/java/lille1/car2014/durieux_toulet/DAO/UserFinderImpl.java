package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.User;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 *
 * @author Thomas Durieux
 */
class UserFinderImpl extends DAOAbs implements UserFinder {

  public UserFinderImpl() {
    initUserDB();
  }

  @Override
  public User getUser(int id) {
    return em.find(UserImpl.class, id);
  }

  @Override
  public User getUserFromUsername(String username) {
    return (User) em.createNamedQuery("User.findByUsername").
            setParameter("username", username).getSingleResult();
  }

  @Override
  public List<User> getAllUsers() {
    return (List<User>) em.createNamedQuery("User.all").getResultList();
  }

  private void initUserDB() {
    User u = new UserImpl("admin", "admin", "admin", "admin");
    UserPersister.INSTANCE.createUser(u);
  }
}
