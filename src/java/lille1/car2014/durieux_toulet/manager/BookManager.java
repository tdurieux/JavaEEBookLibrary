/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.manager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImp;

/**
 *
 * @author Thomas Durieux
 */
public class BookManager {

  @PersistenceContext
  private EntityManager em;

  @Resource
  private UserTransaction utx;

  private String bookTitle;
  private String bookAuthor;
  private int bookYear = 2014;

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

  public String createBook() {
    Book book = new BookImp(bookTitle, bookAuthor, bookYear);
    try {
      utx.begin();
      em.persist(book);
      utx.commit();
    } catch (NotSupportedException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SystemException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RollbackException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicMixedException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (HeuristicRollbackException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SecurityException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalStateException ex) {
      Logger.getLogger(BookManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return "index";
  }

  public List<Book> getBooks() {
    return (List<Book>) em.createNamedQuery("books.getAllBooks").getResultList();
  }
}
