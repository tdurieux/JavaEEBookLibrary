package lille1.car2014.durieux_toulet.api;

import javax.ws.rs.Consumes;
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
 * provides api form book access (url: /api/*)
 *
 * @author Thomas Durieux
 */
public interface BookApi {

  /**
   * Create a book (method: PUT url: /api/book/_BookTitle_), book data are in
   * the body of the request (format: JSON)
   *
   * @param bookTitle the title of the book
   * @param book      the body of the request
   *
   * @return the request response
   */
  @PUT
  @Path(value = "/book/{title: .*}")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  Response createBook(@PathParam(value = "title") String bookTitle, String book);

  /**
   * Edit a book (method: POST url: /api/book/_BookTitle_), book data are in the
   * body of the request (format: JSON)
   *
   * @param bookTitle the title of the book
   * @param book      the body of the request
   *
   * @return the request response
   */
  @POST
  @Path(value = "/book/{title: .*}")
  @Produces(value = MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  Response editBook(@PathParam(value = "title") String bookTitle, String book);

  /**
   * Get a book (method: GET url: /api/book/_BookTitle_)
   *
   * @param bookTitle the title of the book
   *
   * @return the request response
   */
  @GET
  @Path(value = "/book/{title: .*}")
  @Produces(value = MediaType.APPLICATION_JSON)
  Response getBook(@PathParam(value = "title") String bookTitle);

  /**
   * Get all books (method: GET url: /api/books)
   *
   * @return all book
   */
  @GET
  @Path(value = "/books")
  @Produces(value = MediaType.APPLICATION_JSON)
  Response getBooks();

  /**
   * Remove a book (method: DELETE url: /api/book/_BookTitle_)
   *
   * @param bookTitle the title of the book
   *
   * @return the request response
   */
  @DELETE
  @Path(value = "/book/{title: .*}")
  @Produces(value = MediaType.APPLICATION_JSON)
  Response removeBook(@PathParam(value = "title") String bookTitle);

}
