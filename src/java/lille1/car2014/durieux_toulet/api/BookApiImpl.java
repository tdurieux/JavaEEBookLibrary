package lille1.car2014.durieux_toulet.api;

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

/**
 *
 * @author Thomas Durieux
 */
@Path("/")
public class BookApiImpl {

  @Context
  HttpHeaders requestHeaders;
  @Context
  UriInfo uriInfo;

  /**
   * @see PaserelleFTP
   */
  @GET
  @Path("/books")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBooks() {
    return Response.ok(BookFinder.INSTANCE.getAllBooks()).status(200).build();
  }

  /**
   * @see PaserelleFTP
   */
  @GET
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBook(@PathParam("title") String bookTitle) {
    return Response.ok(BookFinder.INSTANCE.getBook(bookTitle)).status(200).build();
  }

  /**
   * @see PaserelleFTP
   */
  @PUT
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response createBook(@PathParam("title") String bookTitle) {
    return Response.ok("{1:'test'}").status(404).build();
  }

  /**
   * @see PaserelleFTP
   */
  @POST
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response editBook(@PathParam("title") String bookTitle) {
    return Response.ok("{1:'test'}").status(404).build();
  }

  /**
   * @see PaserelleFTP
   */
  @DELETE
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response removeBook(@PathParam("title") String bookTitle) {
    return Response.ok("{1:'test'}").status(404).build();
  }
}
