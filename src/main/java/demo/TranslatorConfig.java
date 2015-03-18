package demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.MessageChannel;

@Configuration
@ComponentScan
@EnableIntegration
public class TranslatorConfig {

	@Bean
	public MessageChannel input() {
		return new DirectChannel();
	}

	@Bean
	MessageChannel output() {
		return new DirectChannel();
	}

	@Bean
	public IntegrationFlow myFlow() {
		return IntegrationFlows
				.from(input())
				.handle("translator", "translate")
				.channel(output())
				.get();
	}	
	
}
