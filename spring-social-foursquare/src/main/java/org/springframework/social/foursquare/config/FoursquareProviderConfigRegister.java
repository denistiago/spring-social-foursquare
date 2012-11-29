package org.springframework.social.foursquare.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.social.config.annotation.ProviderConfigRegistrarSupport;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.config.xml.UserIdSource;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.foursquare.api.Foursquare;
import org.springframework.social.foursquare.connect.FoursquareConnectionFactory;

public class FoursquareProviderConfigRegister extends ProviderConfigRegistrarSupport{

	
	
	public FoursquareProviderConfigRegister() {
		super(EnableFoursquare.class, FoursquareConnectionFactory.class, FoursquareApiHelper.class);
	}
	
	
	static class FoursquareApiHelper implements ApiHelper<Foursquare> {

		private final UsersConnectionRepository usersConnectionRepository;

		private final UserIdSource userIdSource;

		private FoursquareApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
			this.usersConnectionRepository = usersConnectionRepository;
			this.userIdSource = userIdSource;
		}

		public Foursquare getApi() {
			if (logger.isDebugEnabled()) {
				logger.debug("Getting API binding instance for Facebook provider");
			}
					
			Connection<Foursquare> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Foursquare.class);
			if (logger.isDebugEnabled() && connection == null) {
				logger.debug("No current connection; Returning default FacebookTemplate instance.");
			}
			return connection != null ? connection.getApi() : null;
		}
		
		private final static Log logger = LogFactory.getLog(FoursquareApiHelper.class);
		
	}

}
