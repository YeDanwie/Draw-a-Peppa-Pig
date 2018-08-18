import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class ParseToXML {
	private Document document;
	private Element rootElement;
	
	public ParseToXML() throws Exception{
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		document = dBuilder.newDocument();
		rootElement = document.createElement("dictionary");
	}
	public void createNode(){		
		File file = new File("dictionary.txt");
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			int count=1;
			while((line=br.readLine())!=null) {
				String part1 = line.split("   ")[0];
				String part2 = line.split("   ")[1];
				
				Element word = document.createElement("word");
				word.setAttribute("id", String.valueOf(count++));
				
				Element english = document.createElement("english");
				english.setTextContent(part1);
				word.appendChild(english);
				
				Element chinese = document.createElement("chinese");
				chinese.setTextContent(part2);
				word.appendChild(chinese);
				
				rootElement.appendChild(word);
			}
			br.close();
			document.appendChild(rootElement);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void createXML() throws Exception{
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(new File("dictionary.xml"));
		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
		
		System.out.println("transform successfully!");
	}
	
	public static void main(String[] args) throws Exception{
		ParseToXML tool = new ParseToXML();
		tool.createNode();
		tool.createXML();
	}
}
