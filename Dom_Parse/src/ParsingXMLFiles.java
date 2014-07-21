import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ParsingXMLFiles {
	
	public static void main(String[] args)   {
		
		
		 File file = new File("F:\\ANDRO�D\\android_exercises\\Dom_Parse\\Flowers.xml");
				 
		 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		 try {
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document document = db.parse(file);
			document.getDocumentElement().normalize();
			
			//K�k dizin bulma......
			System.out.println("K�k dizin :" + document.getDocumentElement().getNodeName());
			
			//"cicek alt dizininden ka� tane oldu�unu tutuyoruz."
			NodeList liste = document.getElementsByTagName("cicek");
			
			for (int i = 0; i < liste.getLength(); i++) {
				
				Node bag = liste.item(i);
				
				if (bag.getNodeType()==Node.ELEMENT_NODE) {
					Element eleman = (Element) bag;
					
					
					System.out.println("S�ra no : "+ eleman.getAttribute("no"));
					System.out.println("�i�e�in t�r� :" + eleman.getElementsByTagName("tur").item(0).getTextContent().toUpperCase());
					System.out.println("�i�e�in rengi :" + eleman.getElementsByTagName("renk").item(0).getTextContent().toUpperCase());
					System.out.println("�i�e�in fiyat� :" + eleman.getElementsByTagName("fiyat").item(0).getTextContent().toUpperCase());
					System.out.println("---------------------------------------");
					
					}
				 ArrayList<Cicek> listeCicek = new ArrayList<Cicek>();
				 
				
					 Element eleman = (Element) bag;
					 Cicek c = new Cicek();
					 c.setNo(eleman.getAttribute("no"));
					 c.setTur(eleman.getElementsByTagName("tur").item(0).getTextContent());
				     c.setRenk(eleman.getElementsByTagName("renk").item(0).getTextContent());
					 c.setFiyat(eleman.getElementsByTagName("fiyat").item(0).getTextContent());
				     listeCicek.add(c);	
				
				 
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 
		 }
		
}




