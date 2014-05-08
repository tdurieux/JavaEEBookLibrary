package test.lille1.car2014.durieux_toulet.manager;

import lille1.car2014.durieux_toulet.manager.UserManager;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;


public class UserManagerTest {

    @Test
    public void testUserCreation() {
        // Instanciate user manager
        UserManager um = new UserManager();

        // Set user description
        um.setUsername("jack");
        um.setPassword("1234");
        um.setFname("Jack");
        um.setLname("Sparrow");

        // Create user
        um.createUser();

        //assertEquals(?, ?);
    }

}
