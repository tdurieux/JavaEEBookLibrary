package lille1.car2014.durieux_toulet.DAO;

/**
 * is an exception launched when a persistence action fail.
 *
 * @author Thomas Durieux
 */
public class DAOException extends RuntimeException {

  /**
   * Constructor
   */
  public DAOException() {
    super();
  }

  /**
   * Constructor
   *
   * @param message Message of exception
   */
  public DAOException(final String message) {
    super(message);
  }

  /**
   * Constructor
   *
   * @param t Throwable exception
   */
  public DAOException(final Throwable t) {
    super(t);
  }

  /**
   * Constructor
   *
   * @param message Message of exception
   * @param t Throwable exception
   */
  public DAOException(final String message, final Throwable t) {
    super(message, t);
  }
}
