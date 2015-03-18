package demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TempConfig.class)
public class TestFlow {

	@Autowired TempGateway gateway;
	@Autowired Translator translator;
	
	@Test	
	public void testCanadian() {
		String translated = gateway.test("Hello World");
		assertEquals("Hello World, eh?", translated);
	}

	
	@Test
	@DirtiesContext
	public void testTeenager() {
		translator.language = "american-teenager";
		String translated = gateway.test("Hello World");
		assertEquals("Like, Hello World", translated);
	}

}
