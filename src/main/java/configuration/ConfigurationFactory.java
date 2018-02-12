package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import configurationAnnotation.Configuration;


public class ConfigurationFactory {


@Produces
@Configuration
@ApplicationScoped
public Properties getProperties() throws IOException {
	
	InputStream inputStream = Configuration.class.getResourceAsStream("/properties");
	
    Properties properties = new Properties();
    properties.load(inputStream);

    return properties;
	
	
}




}
