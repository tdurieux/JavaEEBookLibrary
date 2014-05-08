package test.lille1.car2014.durieux_toulet;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import test.lille1.car2014.durieux_toulet.entity.BookImplTest;
import test.lille1.car2014.durieux_toulet.entity.OrderImplTest;
import test.lille1.car2014.durieux_toulet.entity.UserImplTest;
import test.lille1.car2014.durieux_toulet.manager.BookManagerTest;
import test.lille1.car2014.durieux_toulet.manager.UserManagerTest;

/**
 * @author Toulet Cyrille
 */
public class JUnitRunner {

  /**
   * Main
   *
   * @param args
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
