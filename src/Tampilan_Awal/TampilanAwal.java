package Tampilan_Awal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TampilanAwal implements Initializable {

    @FXML
    private Button buttonBeranda;

    @FXML
    private Button buttonEvaluasiResiokiKredit;

    @FXML
    private Button buttonPenawaranPinjaman;

    @FXML
    private Button buttonPemberianPinjaman;

    @FXML
    private Button buttonPelaporanTransaksi;

    @FXML
    private Button buttonPengajuanPinjaman;

    @FXML
    private Pane paneTampilan;

    @FXML
    private Object buttonManajemenPinjaman;
    
    @FXML
    private Object buttonPencairanDana;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        try {
            if (event.getSource() == buttonPenawaranPinjaman) {
                loadFXMLToPane("/Daftar_Penawaran_Pinjaman/FXMLDocumentTampilan1.fxml");
            } else if (event.getSource() == buttonEvaluasiResiokiKredit) {
                loadFXMLToPane("/Evaluasi_Risiko_Kredit/EvaluasiRisikoKreditView.fxml");
            } else if (event.getSource() == buttonPengajuanPinjaman) {
                loadFXMLToPane("/Pengajuan_Pinjaman/RingkasanPengajuanPinjamanView.fxml");
            } else if (event.getSource() == buttonManajemenPinjaman) {
                loadFXMLToPane("/Manajemen_Pinjaman/DetailPinjamanView.fxml");
            } else if (event.getSource() == buttonPencairanDana) {
                loadFXMLToPane("/Formulir_Pencairan_Dana/FXMLDocumentTampilan1.fxml");
            } else if (event.getSource() == buttonPelaporanTransaksi) {
                loadFXMLToPane("/Pelaporan_Transaksi/item.fxml");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadFXMLToPane(String fxmlFile) throws IOException {
        System.out.println("Memuat file FXML: " + fxmlFile);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        Parent newLoadedPane = loader.load();
        paneTampilan.getChildren().clear();
        paneTampilan.getChildren().add(newLoadedPane);
        System.out.println("File FXML berhasil dimuat");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
