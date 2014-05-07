package lille1.car2014.durieux_toulet.api;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 * Application configuration used to define the path of the rest API
 *
 * @author Thomas Durieux
 */
@javax.ws.rs.ApplicationPath("api")
public class ApiConfig extends Application {

  public ApiConfig() {
    super();
  }

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.addAll(super.getClasses());
    return classes;
  }
}
