package lille1.car2014.durieux_toulet.manager;

import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lille1.car2014.durieux_toulet.DAO.AuthorFinder;
import lille1.car2014.durieux_toulet.DAO.BookFinder;
import lille1.car2014.durieux_toulet.DAO.BookPersister;
import lille1.car2014.durieux_toulet.DAO.DAOException;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 * is an managed bean used to acces book information from jsp pages
 *
 * @author Thomas Durieux
 */
public class BookManager {

  private String bookTitle;
  private String bookAuthor;
  private int bookYear = 2014;
  private String searchTerm;
  private double bookPrice = 0.0;
  private String author;

  public String getBookTitle() {
    return bookTitle;
  }

  public void setBookTitle(String bookTitle) {
    this.bookTitle = bookTitle;
  }

  public String getBookAuthor() {
    return bookAuthor;
  }

  public void setBookAuthor(String bookAuthor) {
    this.bookAuthor = bookAuthor;
  }

  public int getBookYear() {
    return bookYear;
  }

  public void setBookYear(int bookYear) {
    this.bookYear = bookYear;
  }

  public String getSearchTerm() {
    return searchTerm;
  }

  public void setSearchTerm(String searchTerm) {
    this.searchTerm = searchTerm;
  }

  public double getBookPrice() {
    return bookPrice;
  }

  public void setBookPrice(double bookPrice) {
    this.bookPrice = bookPrice;
  }

  /**
   * Get author parameters
   *
   * @return
   */
  public String getAuthor() {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    this.author = (String) facesContext.getExternalContext().
            getRequestParameterMap().get("author");
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  /**
   * Create a new book
   *
   * @return index
   */
  public String createBook() {
    FacesContext context = FacesContext.getCurrentInstance();

    try {
      Book book = new BookImpl(bookTitle, bookAuthor, bookYear, bookPrice);
      BookPersister.INSTANCE.createBook(book);
      return "index";
    } catch (DAOException e) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Create Book Failed!",
              "Title '"
              + bookTitle
              + "' does not exist.");
      context.addMessage(null, message);
      return null;
    }
  }

  /**
   * Search a specific book
   *
   * @return null (refresh)
   */
  public String search() {
    return null;
  }

  /**
   * Get all books
   *
   * @return all books
   */
  public List<Book> getBooks() {
    FacesContext facesContext = FacesContext.getCurrentInstance();
    if (searchTerm != null && searchTerm.trim().length() > 0) {
      return BookFinder.INSTANCE.findBooks(searchTerm);
    }
    String author = (String) facesContext.getExternalContext().
            getRequestParameterMap().get("author");
    if (author != null) {
      this.author = author;
      return BookFinder.INSTANCE.getBookFromAuthor(author);
    }
    return BookFinder.INSTANCE.getAllBooks();
  }

  /**
   * get all authors
   *
   * @return auhtors
   */
  public List<String> getAuthors() {
    return AuthorFinder.INSTANCE.getAllAuthors();
  }
}
