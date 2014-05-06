/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.DAO;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 *
 * @author Thomas Durieux
 */
public class BookPersisterImpl extends DAOAbs implements BookPersister {

  public BookPersisterImpl() {
  }

  @PostConstruct
  public void init() {
    initBookDB();
  }

  @Override
  public void editBook(Book newBook, Book oldBook) {
    try {
      em.getTransaction().begin();
      em.merge(newBook);
      em.getTransaction().commit();
    } catch (SecurityException ex) {
      Logger.getLogger(BookPersisterImpl.class.getName()).log(Level.SEVERE, null, ex);
      em.getTransaction().rollback();
    } catch (IllegalStateException ex) {
      Logger.getLogger(BookPersisterImpl.class.getName()).log(Level.SEVERE, null, ex);
      em.getTransaction().rollback();
    }
  }

  @Override
  public void removeBook(Book book) {
    try {
      em.getTransaction().begin();
      em.remove((BookImpl) book);
      em.getTransaction().commit();
    } catch (SecurityException ex) {
      Logger.getLogger(BookPersisterImpl.class.getName()).log(Level.SEVERE, null, ex);
      em.getTransaction().rollback();
    } catch (IllegalStateException ex) {
      Logger.getLogger(BookPersisterImpl.class.getName()).log(Level.SEVERE, null, ex);
      em.getTransaction().rollback();
    }
  }

  @Override
  public void createBook(Book book) {
    try {
      em.getTransaction().begin();
      em.persist((BookImpl) book);
      em.getTransaction().commit();
    } catch (Exception ex) {
      em.getTransaction().rollback();
      Logger.getLogger(BookPersisterImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void initBookDB() {
    Book book = new BookImpl("RMI", "Author", 1990, 9.87);
    createBook(book);
    book = new BookImpl("JavaEE", "Author", 1990, 9.87);
    createBook(book);
    book = new BookImpl("Rest", "Author", 1990, 9.87);
    createBook(book);
    book = new BookImpl("RMI", "Author", 1990, 9.87);
    createBook(book);
  }

}
