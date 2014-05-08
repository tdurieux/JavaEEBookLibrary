package test.lille1.car2014.durieux_toulet.entity;

import lille1.car2014.durieux_toulet.entity.UserImpl;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserImplTest {

  @Test
  public void testUserConstructorWithoutParameters() {
    // Instanciate user
    UserImpl user = new UserImpl();

    // Test construction of user2
    assertEquals(null, user.getId());
    assertEquals(null, user.getFirstname());
    assertEquals(null, user.getLastname());
    assertEquals(null, user.getUsername());
    assertEquals(null, user.getPassword());
  }

  @Test
  public void testUserConstructorWithParameters() {
    // user data
    Integer id = 42;
    String firstname = "Jack";
    String lastname = "Sparrow";
    String username = "jack";
    String password = "1234";

    // Instanciate users
    UserImpl user1 = new UserImpl(id);
    UserImpl user2 = new UserImpl(firstname, lastname, username, password);
    UserImpl user3 = new UserImpl(id, firstname, lastname, username, password);

    // Test construction of user1
    assertEquals(id, user1.getId());
    assertEquals(null, user1.getFirstname());
    assertEquals(null, user1.getLastname());
    assertEquals(null, user1.getUsername());
    assertEquals(null, user1.getPassword());

    // Test construction of user2
    assertEquals(null, user2.getId());
    assertEquals(firstname, user2.getFirstname());
    assertEquals(lastname, user2.getLastname());
    assertEquals(username, user2.getUsername());
    assertEquals(password, user2.getPassword());

    // Test construction of user3
    assertEquals(id, user3.getId());
    assertEquals(firstname, user3.getFirstname());
    assertEquals(lastname, user3.getLastname());
    assertEquals(username, user3.getUsername());
    assertEquals(password, user3.getPassword());
  }

}
