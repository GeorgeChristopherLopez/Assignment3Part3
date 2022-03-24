import org.xml.sax.*;
import java.io.*;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class DomParserSchema {
	public static void main(String[] args) {
		boolean valid = true;
		try {
			validate("simple.xml", "simple.xsd");
		} catch (SAXException e) {
			System.out.println("SAXExceptoin: "+ e);
			valid = false;
		} catch (IOException e) {
			System.out.println("IOEXCEPTION: "+ e);
			
			valid = false;
		}
		
		if(valid) {
			System.out.print("file is valid");
		} else {
			System.out.print("file is NOT valid");
		}
	}
	
	public static void validate(String xmlfile, String xsdfile) throws SAXException, IOException {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		((schemaFactory.newSchema(new File(xsdfile))).newValidator()).validate(new StreamSource(new File(xmlfile)));
	}
}
