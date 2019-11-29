  
package ie.gmit.ds;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UserApiApplication extends Application<UserApiConfig> {

    public static final Logger logger = LoggerFactory.getLogger(UserApiApplication.class);
	

    public static void main(String[] args) throws Exception {
        new UserApiApplication().run(args);
    }

    public void run(UserApiConfig userApiConfig, Environment environment) throws Exception {

        final ExampleHealthCheck hc = new ExampleHealthCheck();
		//environment.healthChecks().register("Example", hc);
		
		logger.info("Retrieve resources");
		environment.jersey().register(new UserApiResource(environment.getValidator()));
		//final UserApiResource resource = new UserApiResource();
		environment.healthChecks().register("Health Check:", new ExampleHealthCheck());
		
		//environment.jersey().register(resource);
    }

}