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

  public BookFinderImpl() {
    initBookDB();
  }

  @Override
  public List<Book> getAllBooks() {
    return (List<Book>) em.createNamedQuery("books.getAllBooks").getResultList();
  }

  @Override
  public List<Book> findBooks(String title) {
    return (List<Book>) em.createNamedQuery("books.findByTitle").setParameter("title", "%" + title + "%").getResultList();
  }

  @Override
  public List<Book> getBookFromAuthor(String author) {
    return (List<Book>) em.createNamedQuery("books.findByAuthor").setParameter("author", author).getResultList();
  }

  @Override
  public Book getBook(String title) {
    return em.find(BookImpl.class, title);
  }

  private void initBookDB() {
    Book book = new BookImpl("RMI", "Info", 1990, 9.87);
    BookPersister.INSTANCE.createBook(book);
    book = new BookImpl("JavaEE", "Info", 1920, 5.87);
    BookPersister.INSTANCE.createBook(book);
    book = new BookImpl("Rest", "Info", 1910, 3.87);
    BookPersister.INSTANCE.createBook(book);

    book = new BookImpl("Bible", "Eglise", 0, 20.0);
    BookPersister.INSTANCE.createBook(book);
  }
}
