package lille1.car2014.durieux_toulet.entity;

/**
 * is user defined by an id, only authenticated user can add new book
 *
 * @author Thomas Durieux
 */
public interface User {

  /**
   * get the user id
   *
   * @return the id
   */
  Integer getId();

  /**
   * the the firstname
   *
   * @return the firstname
   */
  String getFirstname();

  /**
   * get the last name
   *
   * @return the lastname
   */
  String getLastname();

  /**
   * get the username
   *
   * @return the username
   */
  String getUsername();

  /**
   * get the password
   *
   * @return the password
   */
  String getPassword();
}
