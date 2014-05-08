package lille1.car2014.durieux_toulet.DAO;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lille1.car2014.durieux_toulet.entity.UserImpl;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 * is an abstract object witch provides EntityManager access to child classes.
 *
 * @author Thomas Durieux
 */
public class DAOAbs {

  protected EntityManager em = new EntityManagerUtility().getEntityManager();

  /**
   * is a static class used to create the EntityManager singloton
   */
  public static class EntityManagerUtility {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static final String ENTITYMANAGERNAME = "book.library.persistence";

    /**
     * Get or create the EntityManager
     *
     * @return the EntityManager
     */
    public EntityManager getEntityManager() {
      if (emf == null) {
        Map<String, Object> prop = new HashMap<String, Object>();
        prop.put(PersistenceUnitProperties.CLASSLOADER,
                UserImpl.class.getClassLoader());
        emf = Persistence.createEntityManagerFactory(ENTITYMANAGERNAME, prop);
      }
      if (em == null) {
        em = emf.createEntityManager();
      }
      return em;
    }

    /**
     * Close the EntityManager
     */
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
