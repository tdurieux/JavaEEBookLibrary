/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.DAO;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lille1.car2014.durieux_toulet.entity.UserImpl;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 *
 * @author Thomas Durieux
 */
public class DAOAbs {

  protected EntityManager em = new EntityManagerUtility().getEntityManager();

  public static class EntityManagerUtility {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public EntityManager getEntityManager() {
      if (emf == null) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put(PersistenceUnitProperties.CLASSLOADER,
                UserImpl.class.getClassLoader());
        emf = Persistence.createEntityManagerFactory("book.library.persistence", prop);
      }
      if (em == null) {
        em = emf.createEntityManager();
      }
      return em;
    }

    public void closeEntities() {
      if (em != null) {
        em.close();
        em = null;
      }
      if (emf != null) {
        emf.close();
        emf = null;
      }
    }
  }
}
