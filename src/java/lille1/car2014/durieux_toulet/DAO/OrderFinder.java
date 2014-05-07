package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.Order;

/**
 * is a DAO used to find order
 *
 * @author Thomas Durieux
 */
public interface OrderFinder {

  OrderFinder INSTANCE = new OrderFinderImpl();

  List<Order> listAllOrder();
}
