package Registrasi_Pengguna;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLHandler {

    public static void saveUsersToXML(List<User> users, String filePath) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("users");
            doc.appendChild(rootElement);

            for (User user : users) {
                Element userElement = doc.createElement("user");

                Element username = doc.createElement("username");
                username.appendChild(doc.createTextNode(user.getUsername()));
                userElement.appendChild(username);

                Element password = doc.createElement("password");
                password.appendChild(doc.createTextNode(user.getPassword()));
                userElement.appendChild(password);

                Element date = doc.createElement("date");
                date.appendChild(doc.createTextNode(user.getDate()));
                userElement.appendChild(date);

                Element time = doc.createElement("time");
                time.appendChild(doc.createTextNode(user.getTime()));
                userElement.appendChild(time);

                Element daftarSebagai = doc.createElement("daftarSebagai");
                daftarSebagai.appendChild(doc.createTextNode(user.getDaftarSebagai()));
                userElement.appendChild(daftarSebagai);

                rootElement.appendChild(userElement);
            }

            // Tulis konten ke dalam file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsersFromXML(String filePath) {
        List<User> users = new ArrayList<>();
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("user");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                    String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                    String date = eElement.getElementsByTagName("date").item(0).getTextContent();
                    String time = eElement.getElementsByTagName("time").item(0).getTextContent();
                    String daftarSebagai = eElement.getElementsByTagName("daftarSebagai").item(0).getTextContent();

                    users.add(new User(username, password, date, time, daftarSebagai));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}
