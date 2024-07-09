package Formulir_Pencairan_Dana;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentControllerTampilan1 implements Initializable {

    @FXML
    private Button buttonKirimPermintaan;
    @FXML
    private TextField textNamaDepanPemilikUsaha;
    @FXML
    private TextField textNamaBelakangPemilikUsaha;
    @FXML
    private TextField textNomorKTP;
    @FXML
    private TextField textAlamatLengkap;
    @FXML
    private ChoiceBox<String> cbPilihBank;
    @FXML
    private TextField textMasukanNomorRekening;
    @FXML
    private TextField textMasukanNominalPencairanDana;
    @FXML
    private TextField textNomorHandphone;
    @FXML
    private TextField textAlamatEmail;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        // Semua TextField terisi
        if (textNamaDepanPemilikUsaha.getText().isEmpty() ||
            textNamaBelakangPemilikUsaha.getText().isEmpty() ||
            textNomorKTP.getText().isEmpty() ||
            textAlamatLengkap.getText().isEmpty() ||
            cbPilihBank.getValue() == null ||
            textMasukanNomorRekening.getText().isEmpty() ||
            textMasukanNominalPencairanDana.getText().isEmpty() ||
            textNomorHandphone.getText().isEmpty() ||
            textAlamatEmail.getText().isEmpty()) {
            
            // Pesan peringatan
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Peringatan");
            alert.setHeaderText(null);
            alert.setContentText("Harap isi semua kolom yang wajib diisi.");
            alert.showAndWait();
        } else {
            // Data FormulirData
            String namaDepan = textNamaDepanPemilikUsaha.getText();
            String namaBelakang = textNamaBelakangPemilikUsaha.getText();
            String nomorKTP = textNomorKTP.getText();
            String alamatLengkap = textAlamatLengkap.getText();
            String bankPilihan = cbPilihBank.getValue();
            String nomorRekening = textMasukanNomorRekening.getText();
            String nominalPencairan = textMasukanNominalPencairanDana.getText();
            String nomorHandphone = textNomorHandphone.getText();
            String alamatEmail = textAlamatEmail.getText();

            // Simpan data objek FormulirData
            FormulirData data = new FormulirData();
            data.setNamaDepan(namaDepan);
            data.setNamaBelakang(namaBelakang);
            data.setNomorKTP(nomorKTP);
            data.setAlamatLengkap(alamatLengkap);
            data.setBankPilihan(bankPilihan);
            data.setNomorRekening(nomorRekening);
            data.setNominalPencairan(nominalPencairan);
            data.setNomorHandphone(nomorHandphone);
            data.setAlamatEmail(alamatEmail);

            // Simpan data ke XML
            XMLHandler.saveFormDataToXML(data, "data_formulir_pencairan_dana.xml");

            // Menampilkan Formulir_Pencairan_Dana/FXMLDocumentTampilan2.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Formulir_Pencairan_Dana/FXMLDocumentTampilan2.fxml"));
            Parent root = loader.load();
            FXMLDocumentControllerTampilan2 controller = loader.getController();

            // Kirim data ke Formulir_Pencairan_Dana/FXMLDocumentTampilan2.fxml
            controller.addFormData(data);

            // Tampilkan Formulir_Pencairan_Dana/FXMLDocumentTampilan2.fxml
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Atur TextFormatter
        textNomorKTP.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("\\d*")) ? change : null));
        textMasukanNomorRekening.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("\\d*")) ? change : null));
        textMasukanNominalPencairanDana.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("\\d*")) ? change : null));
        textNomorHandphone.setTextFormatter(new TextFormatter<>(change -> (change.getControlNewText().matches("\\d*")) ? change : null));

        // Inisialisasi ChoiceBox cbPilihBank
        cbPilihBank.setItems(FXCollections.observableArrayList(
            "Bank Central Asia (BCA)",
            "Bank Rakyat Indonesia (BRI)",
            "Bank Negara Indonesia (BNI)",
            "Bank Mandiri",
            "Bank Syariah Indonesia (BSI)",
            "Bank Tabungan Negara (BTN)"));
    }
}
