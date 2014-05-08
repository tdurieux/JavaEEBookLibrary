package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.UserManager;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class UserManagerTest {

  @Test
  public void testUserCreation() {
    // Instanciate user manager
    UserManager um = new UserManager();

    // user data
    String firstname = "Jack";
    String lastname = "Sparrow";
    String username = "jack";
    String password = "1234";

    // Set user description
    um.setUsername(username);
    um.setPassword(password);
    um.setFname(firstname);
    um.setLname(lastname);

    // Create user
    String user = um.createUser();

    // Do tests
    assertEquals(firstname, um.getUser(username).getFirstname());
    assertEquals(lastname, um.getUser(username).getLastname());
    assertEquals(username, um.getUser(username).getUsername());
    assertEquals(password, um.getUser(username).getPassword());
  }

}
