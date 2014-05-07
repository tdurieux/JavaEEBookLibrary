package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Order;
import lille1.car2014.durieux_toulet.entity.OrderImpl;

/**
 * used to execute all persisten operations on a order (create)
 *
 * @author Thomas Durieux
 */
class OrderPersisterImpl extends DAOAbs implements OrderPersister {

  /**
   *
   * @see OrderPersister
   */
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
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new DAOException("Unable to create order", e);
    }
  }

}
