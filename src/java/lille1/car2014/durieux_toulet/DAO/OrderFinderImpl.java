package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.Order;

/**
 * is a DAO used to find order
 *
 * @author Thomas Durieux
 */
class OrderFinderImpl extends DAOAbs implements OrderFinder {

  /**
   * @see OrderFinder
   */
  @Override
  public List<Order> listAllOrder() {
    return (List<Order>) em.createNamedQuery("order.getAllOrder").getResultList();
  }

}
