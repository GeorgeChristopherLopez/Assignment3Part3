import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.*;
public class DomParserDTD {
	public static void main(String[] args) {
		boolean valid = true;
		
		try {
			validate("simple-dtd.xml");
		} catch (ParserConfigurationException e) {
			System.out.println("ParserConfigurationException:" + e);
			valid =false;
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException:" + e);
			valid =false;
		} catch (SAXException e) {
			System.out.println("SAXException:" + e);
			valid =false;
		} catch (IOException e) {
			System.out.println("IOException:" + e);
			valid = false;
			
		}
		
		if(valid) {
			System.out.print("file is valid");
		} else {
			System.out.print("file is NOT valid");
		}
	}
	
	public static void validate(String xmlfile) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		DocumentBuilderFactory documentBuilderFactory  = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				throw exception;
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				throw exception;
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				// TODO Auto-generated method stub
				throw exception;
			}
			
		});
		documentBuilder.parse(new FileInputStream(xmlfile));
		
	}
}
