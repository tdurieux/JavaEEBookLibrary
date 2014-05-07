package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.User;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 * used to execute all persisten operations on a user (create, edit, remove)
 *
 * @author Thomas Durieux
 */
class UserPersisterImpl extends DAOAbs implements UserPersister {

  /**
   * @see UserPersister
   */
  @Override
  public void createUser(User user) {
    try {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      em.getTransaction().begin();
      em.persist((UserImpl) user);
      em.getTransaction().commit();
    } catch (Exception e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new DAOException("Unable to create user", e);
    }
  }

  /**
   * @see UserPersister
   */
  @Override
  public void removeUser(User user) {
    try {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      em.getTransaction().begin();
      em.remove((UserImpl) user);
      em.getTransaction().commit();
    } catch (Exception e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new DAOException("Unable to remove user", e);
    }
  }

  /**
   * @see UserPersister
   */
  @Override
  public void editUser(User newUser, User oldUser) {
    try {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      em.getTransaction().begin();
      em.merge((UserImpl) newUser);
      em.getTransaction().commit();
    } catch (Exception e) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new DAOException("Unable to edit user", e);
    }
  }
}
