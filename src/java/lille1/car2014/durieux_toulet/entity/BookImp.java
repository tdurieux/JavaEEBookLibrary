/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lille1.car2014.durieux_toulet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "books")
@NamedQueries({
  @NamedQuery(name = "books.findByTitle", query = "SELECT b FROM BookImp b WHERE b.title = :title"),
  @NamedQuery(name = "books.getAllBooks", query = "SELECT b FROM BookImp b"),
  @NamedQuery(name = "books.findByAuthor", query = "SELECT b FROM BookImp b WHERE b.author = :author")})
public class BookImp implements Book {

  @Id
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "author", nullable = false)
  private String author;
  @Column(name = "book_year", nullable = false)
  private int year;

  public BookImp() {

  }

  public BookImp(String title, String author, int year) {
    this.title = title;
    this.author = author;
    this.year = year;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

}
