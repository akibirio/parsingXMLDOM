package XMLDomParser;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * DomParserDemo
 */
public class DomParserDemo {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/XMLDomParser/xml_input.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.parse(inputFile);
            document.getDocumentElement().normalize();

            System.out.println("Root Element: " + document.getDocumentElement().getNodeName());
            NodeList nodeList = document.getElementsByTagName("student");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nodeList.getLength(); temp++) {
                Node node = nodeList.item(temp);
                System.out.println("\nCurrent Element :" + node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    System.out.println("Student Roll No: " + element.getAttribute("rollno"));
                    System.out.println(
                            "First Name : " + element.getElementsByTagName("firstname").item(0).getTextContent());
                    System.out.println(
                            "Last Name : " + element.getElementsByTagName("lastname").item(0).getTextContent());
                    System.out.println(
                            "Nick Name : " + element.getElementsByTagName("nickname").item(0).getTextContent());
                    System.out.println("Marks : " + element.getElementsByTagName("marks").item(0).getTextContent());

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}