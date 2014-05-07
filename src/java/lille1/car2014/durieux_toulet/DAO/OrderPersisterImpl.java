package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Order;
import lille1.car2014.durieux_toulet.entity.OrderImpl;

/**
 *
 * @author Thomas Durieux
 */
class OrderPersisterImpl extends DAOAbs implements OrderPersister {

  @Override
  public void createOrder(Order order) {
    try {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      em.getTransaction().begin();
      em.persist((OrderImpl) order);
      em.getTransaction().commit();
    } catch (Exception e) {
      em.getTransaction().rollback();
      throw new RuntimeException(e);
    }
  }

}
