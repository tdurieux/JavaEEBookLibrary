package lille1.car2014.durieux_toulet.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * provides api form order access (url: /api/*)
 *
 * @author Thomas Durieux
 */
public interface OrderApi {

  /**
   * Get the cart (method: GET url: /api/cart),
   *
   * @return the cart
   */
  @GET
  @Path("/cart")
  @Produces(MediaType.APPLICATION_JSON)
  Response getCart();

  /**
   * Add a book to the cart (method: PUT url: /api/cart/_BookTitle__Quantity_)
   *
   * @param bookTitle the title of the book
   * @param quantity  the quantity
   *
   * @return the cart
   */
  @PUT
  @Path("/cart/{title: .*}/{quantity: [0-9]+}")
  @Produces(MediaType.APPLICATION_JSON)
  Response addBook(@PathParam("title") String bookTitle, @PathParam("quantity") String quantity);

  /**
   * Change book quanity (method: POST url: /api/cart/_BookTitle_/_Quantity_)
   *
   * @param bookTitle the title of the book
   * @param quantity  the quantity
   *
   * @return the cart
   */
  @POST
  @Path("/cart/{title: .*}/{quantity: [0-9]+}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response editBook(@PathParam("title") String bookTitle, @PathParam("quantity") String quantity);

  /**
   * Remove a books of the cart (method: DELETE url: /api/cart/_BookTitle_)
   *
   * @param bookTitle
   *
   * @return the cart
   */
  @DELETE
  @Path("/cart/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response removeBook(@PathParam("title") String bookTitle);

  /**
   * Checkout the cart (method: put url: /api/cart/checkout)
   *
   * @return the cart
   */
  @PUT
  @Path("/cart/checkout")
  @Produces(MediaType.APPLICATION_JSON)
  public Response checkout();

}
