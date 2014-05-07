package lille1.car2014.durieux_toulet.api;

import java.util.Map;
import javax.faces.context.FacesContext;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import lille1.car2014.durieux_toulet.DAO.BookFinder;
import lille1.car2014.durieux_toulet.DAO.OrderPersister;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.OrderImpl;
import lille1.car2014.durieux_toulet.manager.OrderManager;

/**
 * is the class witch provides order api (url: /api/*)
 *
 * @author Thomas Durieux
 */
@Path("/")
public class OrderApiImpl implements OrderApi {

  @Context
  HttpHeaders requestHeaders;
  @Context
  UriInfo uriInfo;

  /**
   * @see OrderApi
   */
  @GET
  @Path("/cart")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response getCart() {
    return Response.ok(getOrder()).status(200).build();
  }

  /**
   * @see BookApi
   */
  @PUT
  @Path("/cart/{title: .*}/{quantity: [0-9]+}")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response addBook(@PathParam("title") String bookTitle, @PathParam("quantity") String quantity) {
    Book book = BookFinder.INSTANCE.getBook(bookTitle);
    int quan = Integer.parseInt(quantity);
    getOrder().addBook(book, quan);
    return Response.ok(getOrder()).status(200).build();
  }

  /**
   * @see OrderApi
   */
  @POST
  @Path("/cart/{title: .*}/{quantity: [0-9]+}")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response editBook(@PathParam("title") String bookTitle, @PathParam("quantity") String quantity) {
    Book book = BookFinder.INSTANCE.getBook(bookTitle);
    int quan = Integer.parseInt(quantity);
    getOrder().editBookQuantity(book, quan);
    return Response.ok(getOrder()).status(200).build();
  }

  /**
   * @see OrderApi
   */
  @DELETE
  @Path("/cart/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response removeBook(@PathParam("title") String bookTitle) {
    Book book = BookFinder.INSTANCE.getBook(bookTitle);
    getOrder().removeBook(book);
    return Response.ok(getOrder()).status(200).build();
  }

  @PUT
  @Path("/cart/checkout")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response checkout() {
    OrderPersister.INSTANCE.createOrder(getOrder());
    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
    sessionMap.put(OrderManager.CART_SESSION_KEY, new OrderImpl());
    return Response.ok("ok").status(200).build();
  }

  private OrderImpl getOrder() {
    FacesContext context = FacesContext.getCurrentInstance();
    Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
    OrderImpl order = null;
    if (sessionMap.containsKey(OrderManager.CART_SESSION_KEY)) {
      order = (OrderImpl) sessionMap.get(OrderManager.CART_SESSION_KEY);
    } else {
      order = new OrderImpl();
      sessionMap.put(OrderManager.CART_SESSION_KEY, order);
    }
    return order;
  }
}
