package Formulir_Pencairan_Dana;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.LinkedList;

public class XMLHandler {

    // Metode untuk menyimpan data FormulirData ke XML
    public static void saveFormDataToXML(FormulirData data, String fileName) {
        try {
            // Inisialisasi DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc;

            // Jika file XML sudah ada, muat dokumen yang ada
            File file = new File(fileName);
            if (file.exists()) {
                doc = builder.parse(file);
                doc.getDocumentElement().normalize();
            } else {
                // Jika file XML tidak ada, buat dokumen baru
                doc = builder.newDocument();
                Element rootElement = doc.createElement("FormulirDataList");
                doc.appendChild(rootElement);
            }

            // Buat elemen baru untuk data formulir
            Element newFormDataElement = createFormDataElement(doc, data);

            // Tambahkan elemen baru ke dokumen
            Node root = doc.getDocumentElement();
            root.appendChild(newFormDataElement);

            // Simpan perubahan ke file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metode untuk menyimpan LinkedList<FormulirData> ke XML
    public static void saveFormDataToXML(LinkedList<FormulirData> dataList, String fileName) {
        try {
            // Inisialisasi DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            // Buat elemen root
            Element rootElement = doc.createElement("FormulirDataList");
            doc.appendChild(rootElement);

            // Tambahkan data ke root
            for (FormulirData data : dataList) {
                Element formDataElement = createFormDataElement(doc, data);
                rootElement.appendChild(formDataElement);
            }

            // Simpan perubahan ke file XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metode untuk membuat elemen FormulirData
    private static Element createFormDataElement(Document doc, FormulirData data) {
        Element formDataElement = doc.createElement("FormulirData");

        // Tambahkan elemen ke formDataElement
        createChildElement(doc, formDataElement, "namaDepan", data.getNamaDepan());
        createChildElement(doc, formDataElement, "namaBelakang", data.getNamaBelakang());
        createChildElement(doc, formDataElement, "nomorKTP", data.getNomorKTP());
        createChildElement(doc, formDataElement, "alamatLengkap", data.getAlamatLengkap());
        createChildElement(doc, formDataElement, "bankPilihan", data.getBankPilihan());
        createChildElement(doc, formDataElement, "nomorRekening", data.getNomorRekening());
        createChildElement(doc, formDataElement, "nominalPencairan", data.getNominalPencairan());
        createChildElement(doc, formDataElement, "nomorHandphone", data.getNomorHandphone());
        createChildElement(doc, formDataElement, "alamatEmail", data.getAlamatEmail());

        return formDataElement;
    }

    // Metode untuk membuat elemen FormulirData
    private static void createChildElement(Document doc, Element parent, String tagName, String textContent) {
        Element element = doc.createElement(tagName);
        element.appendChild(doc.createTextNode(textContent));
        parent.appendChild(element);
    }

    // Metode untuk memuat data dari file XML
    public static LinkedList<FormulirData> loadFormDataFromXML(String fileName) {
        LinkedList<FormulirData> dataList = new LinkedList<>();
        try {
            // Inisialisasi DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(fileName);
            if (!file.exists()) {
                return dataList;
            }

            // Muat dokumen dari file XML
            Document doc = builder.parse(file);
            doc.getDocumentElement().normalize();

            // Ambil semua elemen FormulirData
            NodeList nodeList = doc.getElementsByTagName("FormulirData");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    FormulirData data = new FormulirData();

                    data.setNamaDepan(getTagValue("namaDepan", element));
                    data.setNamaBelakang(getTagValue("namaBelakang", element));
                    data.setNomorKTP(getTagValue("nomorKTP", element));
                    data.setAlamatLengkap(getTagValue("alamatLengkap", element));
                    data.setBankPilihan(getTagValue("bankPilihan", element));
                    data.setNomorRekening(getTagValue("nomorRekening", element));
                    data.setNominalPencairan(getTagValue("nominalPencairan", element));
                    data.setNomorHandphone(getTagValue("nomorHandphone", element));
                    data.setAlamatEmail(getTagValue("alamatEmail", element));

                    dataList.add(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

    // Metode untuk mendapatkan nilai dari elemen XML
    private static String getTagValue(String tagName, Element element) {
        NodeList nodeList = element.getElementsByTagName(tagName).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
