/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.DAO;

import java.util.List;
import lille1.car2014.durieux_toulet.entity.Book;
import lille1.car2014.durieux_toulet.entity.BookImpl;

/**
 *
 * @author Thomas Durieux
 */
public class BookFinderImpl extends DAOAbs implements BookFinder {

  @Override
  public List<Book> getAllBooks() {
    return (List<Book>) em.createNamedQuery("books.getAllBooks").getResultList();
  }

  @Override
  public List<Book> findBooks(String title) {
    return (List<Book>) em.createNamedQuery("books.findByTitle").setParameter("title", title).getResultList();
  }

  @Override
  public List<Book> getBookFromAuthor(String author) {
    return (List<Book>) em.createNamedQuery("books.findByAuthor").setParameter("author", author).getResultList();
  }

  @Override
  public Book getBook(String title) {
    return em.find(BookImpl.class, title);
  }
}
