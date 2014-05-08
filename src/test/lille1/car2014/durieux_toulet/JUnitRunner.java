package test.lille1.car2014.durieux_toulet;

import test.lille1.car2014.durieux_toulet.manager.BookManagerTest;
import test.lille1.car2014.durieux_toulet.manager.UserManagerTest;
import test.lille1.car2014.durieux_toulet.entity.BookImplTest;
import test.lille1.car2014.durieux_toulet.entity.OrderImplTest;
import test.lille1.car2014.durieux_toulet.entity.UserImplTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Toulet Cyrille
 */
public class JUnitRunner {

    /**
     * Main
     */
    public static void main(final String[] args) {
        // Test BookManager
        Result result = JUnitCore.runClasses(BookManagerTest.class);

        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        /* Test UserManager */
        result = JUnitCore.runClasses(UserManagerTest.class);

        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        /* Test BookImpl */
        result = JUnitCore.runClasses(BookImplTest.class);

        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        /* Test OrderImpl */
        result = JUnitCore.runClasses(OrderImplTest.class);

        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        /* Test UserImpl */
        result = JUnitCore.runClasses(UserImplTest.class);

        for (final Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
