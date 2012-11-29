package org.springframework.social.foursquare.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.social.connect.ConnectionFactoryLocator;

/**
 * Annotation to enable Foursquare in a Spring Social application.
 * Configures a {@link FoursquareConnectionFactory} bean (and a {@link ConnectionFactoryLocator} bean if one isn't already registered).
 * 
 * @author Denis Silva
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(FoursquareProviderConfigRegister.class)
public @interface EnableFoursquare {
	String appId();
	String appSecret();
}
