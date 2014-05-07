package lille1.car2014.durieux_toulet.api;

import com.owlike.genson.Genson;
import javax.ws.rs.Consumes;
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
import lille1.car2014.durieux_toulet.DAO.BookPersister;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 * is the class witch provides book api (url: /api/*)
 *
 * @author Thomas Durieux
 */
@Path("/")
public class BookApiImpl implements BookApi {

  @Context
  HttpHeaders requestHeaders;
  @Context
  UriInfo uriInfo;

  /**
   * @see BookApi
   */
  @GET
  @Path("/books")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response getBooks() {
    return Response.ok(BookFinder.INSTANCE.getAllBooks()).status(200).build();
  }

  /**
   * @see BookApi
   */
  @GET
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response getBook(@PathParam("title") String bookTitle) {
    return Response.ok(BookFinder.INSTANCE.getBook(bookTitle)).status(200).build();
  }

  /**
   * @see BookApi
   */
  @PUT
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Override
  public Response createBook(@PathParam("title") String bookTitle, String book) {
    BookImpl newBook = genson().deserialize(book, BookImpl.class);
    BookPersister.INSTANCE.createBook(newBook);
    return Response.ok("ok").status(200).build();
  }

  /**
   * @see BookApi
   */
  @POST
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  @Override
  public Response editBook(@PathParam("title") String bookTitle, String book) {
    Book oldBook = BookFinder.INSTANCE.getBook(bookTitle);
    BookImpl newBook = genson().deserialize(book, BookImpl.class);
    BookPersister.INSTANCE.editBook(newBook, oldBook);
    return Response.ok("ok").status(200).build();
  }

  /**
   * @see BookApi
   */
  @DELETE
  @Path("/book/{title: .*}")
  @Produces(MediaType.APPLICATION_JSON)
  @Override
  public Response removeBook(@PathParam("title") String bookTitle) {
    BookPersister.INSTANCE.removeBook(BookFinder.INSTANCE.getBook(bookTitle));
    return Response.ok("ok").status(200).build();
  }

  private static Genson genson() {
    Genson genson = new Genson.Builder()
            .setSkipNull(true)
            .setWithClassMetadata(false)
            .setWithDebugInfoPropertyNameResolver(true)
            .setWithBeanViewConverter(true)
            .create();

    return genson;
  }
}
