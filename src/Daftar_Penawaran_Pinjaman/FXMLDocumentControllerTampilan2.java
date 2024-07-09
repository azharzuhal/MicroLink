package Daftar_Penawaran_Pinjaman;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FXMLDocumentControllerTampilan2 implements Initializable {

    @FXML
    private Label labelNamaDepan;
    @FXML
    private Label labelNamaBelakang;
    @FXML
    private Label labelUsaha;
    @FXML
    private Label labelTanggalInvestasi;
    @FXML
    private Label labelJumlahInvestasi;
    @FXML
    private Label labelBunga;
    @FXML
    private Label labelBulan;
    @FXML
    private Label labelPengembalianDiterima;
    @FXML
    private Label labelPembayaranTerakhir;
    @FXML
    private Button buttonBack;
    @FXML
    private Button buttonInvestasi;
    @FXML
    private Button buttonPinjam;

    private ObservableList<PenawaranPinjaman> listPenawaran = FXCollections.observableArrayList();

    @FXML
    private void handleButtonBack(ActionEvent event) throws IOException {
        // Kembali ke /FXMLDocumentTampilan1.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Daftar_Penawaran_Pinjaman/FXMLDocumentTampilan1.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void handleButtonInvestasi(ActionEvent event) throws IOException {
        // Menyimpan data dan beralih ke scene berikutnya
        simpanDataDanBeralihScene(event);
    }

    @FXML
    private void handleButtonPinjam(ActionEvent event) throws IOException {
        // Menyimpan data dan beralih ke scene berikutnya
        simpanDataDanBeralihScene(event);
    }

    private void simpanDataDanBeralihScene(ActionEvent event) throws IOException {
        // Simpan data dari label-label ke objek PenawaranPinjaman
        PenawaranPinjaman penawaran = new PenawaranPinjaman(
                labelNamaDepan.getText() + " " + labelNamaBelakang.getText(),
                labelUsaha.getText(),
                labelTanggalInvestasi.getText(),
                labelJumlahInvestasi.getText(),
                labelBunga.getText(),
                labelBulan.getText(),
                labelPengembalianDiterima.getText(),
                labelPembayaranTerakhir.getText()
        );

        // Tambahkan objek PenawaranPinjaman ke listPenawaran
        listPenawaran.add(penawaran);

        // Menampilkan /FXMLDocumentTampilan3.fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Daftar_Penawaran_Pinjaman/FXMLDocumentTampilan3.fxml"));
        Parent parent = loader.load();

        // Transfer data ke /FXMLDocumentTampilan3.fxml
        FXMLDocumentControllerTampilan3 controller = loader.getController();
        controller.initializeData(listPenawaran);

        // Beralih scene
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
