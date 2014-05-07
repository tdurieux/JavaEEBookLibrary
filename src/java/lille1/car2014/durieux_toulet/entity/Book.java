package lille1.car2014.durieux_toulet.entity;

/**
 * is an entity book
 *
 * @author Thomas Durieux
 */
public interface Book {

  /**
   * Get the title of the book
   *
   * @return the title
   */
  String getTitle();

  /**
   * Get the author of the book
   *
   * @return the author
   */
  String getAuthor();

  /**
   * Get the year of publication
   *
   * @return the year
   */
  int getYear();

  /**
   * Get the price in euro of the book
   *
   * @return the price
   */
  double getPrice();
}
