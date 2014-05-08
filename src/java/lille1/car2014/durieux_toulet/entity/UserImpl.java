package lille1.car2014.durieux_toulet.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * is an entity user stored on the table WUSER
 *
 * @author Thomas Durieux
 */
@Entity
@Table(name = "WUSER")
@NamedQueries({
  @NamedQuery(name = "User.findById", query = "SELECT w FROM UserImpl w WHERE w.id = :id"),
  @NamedQuery(name = "User.all", query = "SELECT w FROM UserImpl w"),
  @NamedQuery(name = "User.findByUsername", query = "SELECT w FROM UserImpl w WHERE w.username = :username")})
public class UserImpl implements Serializable, User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "FIRSTNAME", nullable = false)
  private String firstname;

  @Column(name = "LASTNAME", nullable = false)
  private String lastname;

  @Column(name = "USERNAME", nullable = false, unique = true)
  private String username;

  @Column(name = "PASSWORD", nullable = false)
  private String password;

  /**
   * Creates a new instance of UserImpl
   */
  public UserImpl() {
  }

  public UserImpl(Integer id) {
    this.id = id;
  }

  public UserImpl(String firstname, String lastname, String username, String password) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
  }

  public UserImpl(Integer id, String firstname, String lastname, String username, String password) {
    this.id = id;
    this.firstname = firstname;
    this.lastname = lastname;
    this.username = username;
    this.password = password;
  }

  /**
   *
   * @see User
   */
  @Override
  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  /**
   *
   * @see User
   */
  @Override
  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  /**
   *
   * @see User
   */
  @Override
  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  /**
   *
   * @see User
   */
  @Override
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  /**
   *
   * @see User
   */
  @Override
  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
