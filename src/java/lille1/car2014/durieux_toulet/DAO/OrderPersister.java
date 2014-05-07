package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Order;

/**
 *
 * @author Thomas Durieux
 */
public interface OrderPersister {

  OrderPersister INSTANCE = new OrderPersisterImpl();

  void createOrder(Order order);
}
