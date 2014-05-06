package lille1.car2014.durieux_toulet.manager;

import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import lille1.car2014.durieux_toulet.DAO.BookFinder;
import lille1.car2014.durieux_toulet.DAO.OrderPersister;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.OrderImpl;

/**
 *
 * @author Thomas Durieux
 */
@ManagedBean(name = "ordermanager")
public class OrderManager {

  private final String CART_SESSION_KEY = "cart";

  public OrderImpl getOrder() {
    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
    OrderImpl order = null;
    if (sessionMap.containsKey(CART_SESSION_KEY)) {
      order = (OrderImpl) sessionMap.get(CART_SESSION_KEY);
    } else {
      order = new OrderImpl();
      sessionMap.put(CART_SESSION_KEY, order);
    }
    return order;
  }

  public String addBookToCart() {
    FacesContext context = FacesContext.getCurrentInstance();
    OrderImpl order = getOrder();
    Map<String, String> params = context.getExternalContext().getRequestParameterMap();
    String title = params.get("title");
    String key = "order-" + title + ":" + title + "-quantity";
    String s_quantity = params.get(key);
    if (s_quantity == null) {
      s_quantity = "1";
    }
    int quantity = Integer.parseInt(s_quantity);
    Book book = BookFinder.INSTANCE.getBook(title);
    order.addBook(book, quantity);
    return null;
  }

  public String checkout() {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
      OrderImpl order = getOrder();
      OrderPersister.INSTANCE.createOrder(order);
      Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
      order = new OrderImpl();
      sessionMap.put(CART_SESSION_KEY, order);
      return "index";
    } catch (RuntimeException e) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Checkout Failed!",
              "Unable to checkout.");
      context.addMessage(null, message);
      return null;
    }
  }
}
