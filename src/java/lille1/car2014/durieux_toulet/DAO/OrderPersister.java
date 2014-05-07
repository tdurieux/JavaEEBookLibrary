package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Order;

/**
 * used to execute all persisten operations on a order (create)
 *
 * @author Thomas Durieux
 */
public interface OrderPersister {

  OrderPersister INSTANCE = new OrderPersisterImpl();

  /**
   * Create a new order
   *
   * @param order the new order
   */
  void createOrder(Order order);
}
