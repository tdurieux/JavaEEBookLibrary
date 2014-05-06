package lille1.car2014.durieux_toulet.manager;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import lille1.car2014.durieux_toulet.DAO.UserFinder;
import lille1.car2014.durieux_toulet.DAO.UserPersister;
import lille1.car2014.durieux_toulet.entity.UserImpl;

/**
 * <p>
 * A simple managed bean to mediate between the user and the persistence
 * layer.</p>
 *
 * @author rlubke
 */
public class UserManager {

  /**
   * <p>
   * The key for the session scoped attribute holding the appropriate
   * <code>UserImpl</code> instance.</p>
   */
  public static final String USER_SESSION_KEY = "user";

  /**
   * <p>
   * UserImpl properties.</p>
   */
  private String username;
  private String password;
  private String passwordv;
  private String fname;
  private String lname;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordv() {
    return passwordv;
  }

  public void setPasswordv(String passwordv) {
    this.passwordv = passwordv;
  }

  public String getFname() {
    return fname;
  }

  public void setFname(String fname) {
    this.fname = fname;
  }

  public String getLname() {
    return lname;
  }

  public void setLname(String lname) {
    this.lname = lname;
  }

  /**
   * <p>
   * Validates the user. If the user doesn't exist or the password is incorrect,
   * the appropriate message is added to the current <code>FacesContext</code>.
   * If the user successfully authenticates, navigate them to the page
   * referenced by the outcome <code>app-main</code>.
   * </p>
   *
   * @return <code>app-main</code> if the user authenticates, otherwise returns
   *         <code>null</code>
   */
  public String validateUser() {
    FacesContext context = FacesContext.getCurrentInstance();
    try {
      UserImpl user = getUser(username);
      if (!user.getPassword().equals(password)) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Login Failed!",
                "The password specified is not correct.");
        context.addMessage(null, message);
        return null;
      }

      context.getExternalContext().getSessionMap().put(USER_SESSION_KEY, user);
      return "index";
    } catch (NoResultException e) {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Login Failed!",
              "Username '"
              + username
              + "' does not exist.");
      context.addMessage(null, message);
      return null;
    }
  }

  public boolean isConnected() {
    FacesContext context = FacesContext.getCurrentInstance();
    return context.getExternalContext().getSessionMap().containsKey(USER_SESSION_KEY);
  }

  /**
   * <p>
   * Creates a new <code>UserImpl</code>. If the specified user name exists or
   * an error occurs when persisting the UserImpl instance, enqueue a message
   * detailing the problem to the <code>FacesContext</code>. If the user is
   * created, move the user back to the login view.</p>
   *
   * @return <code>login</code> if the user is created, otherwise returns
   *         <code>null</code>
   */
  public String createUser() {
    FacesContext context = FacesContext.getCurrentInstance();
    UserImpl wuser = null;
    List<UserImpl> users = UserFinder.INSTANCE.getAllUsers();
    try {
      wuser = getUser(username);
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Username '"
              + username
              + "' already exists!  ",
              "Please choose a different username.");
      context.addMessage(null, message);
      return null;

    } catch (NoResultException e) {
      if (!password.equals(passwordv)) {
        FacesMessage message = new FacesMessage("The specified passwords do not match.  Please try again");
        context.addMessage(null, message);
        return null;
      }
      wuser = new UserImpl(fname, lname, username, password);

      try {
        UserPersister.INSTANCE.createUser(wuser);
        return "login";
      } catch (Exception e1) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error creating user!",
                "Unexpected error when creating your account.  Please contact the system Administrator");
        context.addMessage(null, message);
        Logger.getAnonymousLogger().log(Level.SEVERE,
                "Unable to create new user",
                e1);
        return null;
      }
    }
  }

  /**
   * <p>
   * When invoked, it will invalidate the user's session and move them to the
   * login view.</p>
   *
   * @return <code>login</code>
   */
  public String logout() {
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    if (session != null) {
      session.invalidate();
    }
    return "login";

  }

  /**
   * <p>
   * This will attempt to lookup a <code>UserImpl</code> object based on the
   * provided user name.</p>
   *
   * @return a <code>UserImpl</code> object associated with the current
   *         username, otherwise, if no <code>UserImpl</code> can be found,
   *         returns <code>null</code>
   */
  private UserImpl getUser(String username) throws NoResultException {
    return UserFinder.INSTANCE.getUserFromUsername(username);
  }
}
