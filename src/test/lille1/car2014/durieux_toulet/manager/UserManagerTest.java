package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.UserManager;
import lille1.car2014.durieux_toulet.DAO.UserFinder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
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
        um.createUser();

        // Do tests
        assertEquals(firstname, UserFinder.INSTANCE.getUserFromUsername(username).getFirstname())
        assertEquals(lastname, UserFinder.INSTANCE.getUserFromUsername(username).getLastname())
        assertEquals(username, UserFinder.INSTANCE.getUserFromUsername(username).getUsername())
        assertEquals(password, UserFinder.INSTANCE.getUserFromUsername(username).getPassword())
    }

}
