/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.DAO;

import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 *
 * @author Thomas Durieux
 */
public class BookPersisterImpl extends DAOAbs implements BookPersister {

  @Override
  public void editBook(Book newBook, Book oldBook) {
    try {
      em.getTransaction().begin();
      em.merge(newBook);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void removeBook(Book book) {
    try {
      em.getTransaction().begin();
      em.remove((BookImpl) book);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void createBook(Book book) {
    try {
      em.getTransaction().begin();
      em.persist((BookImpl) book);
      em.getTransaction().commit();
    } catch (Exception ex) {
      if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
      }
      throw new RuntimeException(ex);
    }
  }

}
