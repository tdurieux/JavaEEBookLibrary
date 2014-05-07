package lille1.car2014.durieux_toulet.entity;

/**
 * is a special user of the application
 *
 * @author Thomas Durieux
 */
public interface User {

  /**
   * get the user id
   *
   * @return the id
   */
  int getId();

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
