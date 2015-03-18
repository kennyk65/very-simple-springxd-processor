package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.integration.gateway.GatewayProxyFactoryBean;

/**
 * This configuration class supports testing of the entire module.  
 * Spring XD processor modules begin and end with channels, but Spring Integration
 * flows need to begin and end with endpoints.  So to support testing, we create this
 * MessagingGateway that knows how to put input on the input channel and get output
 * from the output channel.
 */
@Configuration
@Import(TranslatorConfig.class)
public class TempConfig {

	@Bean
	public GatewayProxyFactoryBean gateway() {
		return new GatewayProxyFactoryBean(TempGateway.class);
	}
	
}
