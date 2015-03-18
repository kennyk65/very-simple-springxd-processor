package demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Translator {

	@Value ("${language}") String language;	//	Requested language to translate into.

	/**
	 *	Translate into the given language / dialect. 
	 */
	public String translate(String something){
		
		if ("mexican".equalsIgnoreCase(language)) {
			return something + ", no?";
		} else if ("american-teenager".equalsIgnoreCase(language)) {
			return "Like, " + something;
		} 
		
		//	Canadian:
		return something + ", eh?";
	}
}
