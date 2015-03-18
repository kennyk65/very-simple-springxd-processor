package demo;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Used to support integration testing by providing an easy way to 
 * put input on the input channel and get output from the output channel.
 */
@MessagingGateway
public interface TempGateway {

	@Gateway(requestChannel="input", replyChannel="output")
	String test(String input);

}	
