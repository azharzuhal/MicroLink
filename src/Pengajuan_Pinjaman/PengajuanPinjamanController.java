package Pengajuan_Pinjaman;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PengajuanPinjamanController {

    @FXML private TextField namaLengkapField;
    @FXML private TextField nomorIdentitasField;
    @FXML private TextField alamatField;
    @FXML private TextField nomorTeleponField;
    @FXML private TextField emailField;
    @FXML private TextField pendapatanBulananField;
    @FXML private TextField pengeluaranBulananField;
    @FXML private TextField sumberPenghasilanField;
    @FXML private TextField jumlahPinjamanField;
    @FXML private TextField usahaYangDibangunField;
    @FXML private TextField jangkaWaktuPinjamanField;
    @FXML private TextField pekerjaanField;
    @FXML private TextField namaPerusahaanField;
    @FXML private TextField alamatTempatKerjaField;
    @FXML private TextField nomorTeleponTempatKerjaField;
    @FXML private TextField dokumenPendukungField;

    private PengajuanPinjaman pengajuan;

    @FXML
    private void handleSubmit() {
        try {
            // Simpan data ke model
            pengajuan = new PengajuanPinjaman();
            pengajuan.setNamaLengkap(namaLengkapField.getText());
            pengajuan.setNomorIdentitas(nomorIdentitasField.getText());
            pengajuan.setAlamat(alamatField.getText());
            pengajuan.setNomorTelepon(nomorTeleponField.getText());
            pengajuan.setEmail(emailField.getText());
            pengajuan.setPendapatanBulanan(pendapatanBulananField.getText());
            pengajuan.setPengeluaranBulanan(pengeluaranBulananField.getText());
            pengajuan.setSumberPenghasilan(sumberPenghasilanField.getText());
            pengajuan.setJumlahPinjaman(jumlahPinjamanField.getText());
            pengajuan.setUsahaYangDibangun(usahaYangDibangunField.getText());
            pengajuan.setJangkaWaktuPinjaman(jangkaWaktuPinjamanField.getText());
            pengajuan.setPekerjaan(pekerjaanField.getText());
            pengajuan.setNamaPerusahaan(namaPerusahaanField.getText());
            pengajuan.setAlamatTempatKerja(alamatTempatKerjaField.getText());
            pengajuan.setNomorTeleponTempatKerja(nomorTeleponTempatKerjaField.getText());
            pengajuan.setDokumenPendukung(dokumenPendukungField.getText());

            // Pindah ke tampilan ringkasan
            FXMLLoader loader = new FXMLLoader(getClass().getResource("RingkasanPengajuanPinjamanView.fxml"));
            Parent root = loader.load();

            // Mengisi data ringkasan
            RingkasanPengajuanPinjamanController controller = loader.getController();
            controller.setPengajuanData(pengajuan);

            Stage stage = (Stage) namaLengkapField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSimpanXML() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save XML File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
            File file = fileChooser.showSaveDialog(namaLengkapField.getScene().getWindow());
            if (file != null) {
                saveToXML(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveToXML(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.newDocument();

        Element rootElement = doc.createElement("PengajuanPinjaman");
        doc.appendChild(rootElement);

        Element namaLengkap = doc.createElement("NamaLengkap");
        namaLengkap.appendChild(doc.createTextNode(namaLengkapField.getText()));
        rootElement.appendChild(namaLengkap);

        Element nomorIdentitas = doc.createElement("NomorIdentitas");
        nomorIdentitas.appendChild(doc.createTextNode(nomorIdentitasField.getText()));
        rootElement.appendChild(nomorIdentitas);

        Element alamat = doc.createElement("Alamat");
        alamat.appendChild(doc.createTextNode(alamatField.getText()));
        rootElement.appendChild(alamat);

        Element nomorTelepon = doc.createElement("NomorTelepon");
        nomorTelepon.appendChild(doc.createTextNode(nomorTeleponField.getText()));
        rootElement.appendChild(nomorTelepon);

        Element email = doc.createElement("Email");
        email.appendChild(doc.createTextNode(emailField.getText()));
        rootElement.appendChild(email);

        Element pendapatanBulanan = doc.createElement("PendapatanBulanan");
        pendapatanBulanan.appendChild(doc.createTextNode(pendapatanBulananField.getText()));
        rootElement.appendChild(pendapatanBulanan);

        Element pengeluaranBulanan = doc.createElement("PengeluaranBulanan");
        pengeluaranBulanan.appendChild(doc.createTextNode(pengeluaranBulananField.getText()));
        rootElement.appendChild(pengeluaranBulanan);

        Element sumberPenghasilan = doc.createElement("SumberPenghasilan");
        sumberPenghasilan.appendChild(doc.createTextNode(sumberPenghasilanField.getText()));
        rootElement.appendChild(sumberPenghasilan);

        Element jumlahPinjaman = doc.createElement("JumlahPinjaman");
        jumlahPinjaman.appendChild(doc.createTextNode(jumlahPinjamanField.getText()));
        rootElement.appendChild(jumlahPinjaman);

        Element usahaYangDibangun = doc.createElement("UsahaYangDibangun");
        usahaYangDibangun.appendChild(doc.createTextNode(usahaYangDibangunField.getText()));
        rootElement.appendChild(usahaYangDibangun);

        Element jangkaWaktuPinjaman = doc.createElement("JangkaWaktuPinjaman");
        jangkaWaktuPinjaman.appendChild(doc.createTextNode(jangkaWaktuPinjamanField.getText()));
        rootElement.appendChild(jangkaWaktuPinjaman);

        Element pekerjaan = doc.createElement("Pekerjaan");
        pekerjaan.appendChild(doc.createTextNode(pekerjaanField.getText()));
        rootElement.appendChild(pekerjaan);

        Element namaPerusahaan = doc.createElement("NamaPerusahaan");
        namaPerusahaan.appendChild(doc.createTextNode(namaPerusahaanField.getText()));
        rootElement.appendChild(namaPerusahaan);

        Element alamatTempatKerja = doc.createElement("AlamatTempatKerja");
        alamatTempatKerja.appendChild(doc.createTextNode(alamatTempatKerjaField.getText()));
        rootElement.appendChild(alamatTempatKerja);

        Element nomorTeleponTempatKerja = doc.createElement("NomorTeleponTempatKerja");
        nomorTeleponTempatKerja.appendChild(doc.createTextNode(nomorTeleponTempatKerjaField.getText()));
        rootElement.appendChild(nomorTeleponTempatKerja);

        Element dokumenPendukung = doc.createElement("DokumenPendukung");
        dokumenPendukung.appendChild(doc.createTextNode(dokumenPendukungField.getText()));
        rootElement.appendChild(dokumenPendukung);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(file);
        transformer.transform(source, result);
    }

    @FXML
    private void handleBacaXML() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open XML File");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
            File file = fileChooser.showOpenDialog(namaLengkapField.getScene().getWindow());
            if (file != null) {
                readFromXML(file);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readFromXML(File file) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("PengajuanPinjaman");

        if (nodeList.getLength() > 0) {
            Node node = nodeList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                namaLengkapField.setText(getTagValue("NamaLengkap", element));
                nomorIdentitasField.setText(getTagValue("NomorIdentitas", element));
                alamatField.setText(getTagValue("Alamat", element));
                nomorTeleponField.setText(getTagValue("NomorTelepon", element));
                emailField.setText(getTagValue("Email", element));
                pendapatanBulananField.setText(getTagValue("PendapatanBulanan", element));
                pengeluaranBulananField.setText(getTagValue("PengeluaranBulanan", element));
                sumberPenghasilanField.setText(getTagValue("SumberPenghasilan", element));
                jumlahPinjamanField.setText(getTagValue("JumlahPinjaman", element));
                usahaYangDibangunField.setText(getTagValue("UsahaYangDibangun", element));
                jangkaWaktuPinjamanField.setText(getTagValue("JangkaWaktuPinjaman", element));
                pekerjaanField.setText(getTagValue("Pekerjaan", element));
                namaPerusahaanField.setText(getTagValue("NamaPerusahaan", element));
                alamatTempatKerjaField.setText(getTagValue("AlamatTempatKerja", element));
                nomorTeleponTempatKerjaField.setText(getTagValue("NomorTeleponTempatKerja", element));
                dokumenPendukungField.setText(getTagValue("DokumenPendukung", element));
            }
        }
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Tampilan_Awal/TampilanAwal.fxml"));
            Stage stage = (Stage) namaLengkapField.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
