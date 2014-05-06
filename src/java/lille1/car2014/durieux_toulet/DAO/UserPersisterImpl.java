/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.DAO;

import javax.annotation.PostConstruct;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 *
 * @author Thomas Durieux
 */
class UserPersisterImpl extends DAOAbs implements UserPersister {

  public UserPersisterImpl() {
  }

  @PostConstruct
  public void init() {
    initUserDB();
  }

  @Override
  public void createUser(UserImpl user) {
    try {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      em.getTransaction().begin();
      em.persist((UserImpl) user);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw new RuntimeException(e);
    }
  }

  @Override
  public void removeUser(UserImpl user) {
    try {
      em.remove((UserImpl) user);
      em.flush();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void editUser(UserImpl newUser, UserImpl oldUser) {
    try {
      em.merge((UserImpl) newUser);
      em.flush();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void initUserDB() {
    UserImpl u = new UserImpl(1, "admin", "admin", "admin", "admin");
    createUser(u);
  }
}
