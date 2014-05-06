package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 *
 * @author Thomas Durieux
 */
class UserFinderImpl extends DAOAbs implements UserFinder {

  @Override
  public UserImpl getUser(int id) {
    return em.find(UserImpl.class, id);
  }

  @Override
  public UserImpl getUserFromUsername(String username) {
    return (UserImpl) em.createNamedQuery("User.findByUsername").
            setParameter("username", username).getSingleResult();
  }

  @Override
  public List<UserImpl> getAllUsers() {
    return (List<UserImpl>) em.createNamedQuery("User.all").getResultList();
  }

}
