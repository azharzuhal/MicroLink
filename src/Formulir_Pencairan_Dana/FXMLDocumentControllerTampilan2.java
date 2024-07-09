package Formulir_Pencairan_Dana;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class FXMLDocumentControllerTampilan2 implements Initializable {

    @FXML
    private TableView<FormulirData> tableViewFormulirPencairanDana;

    @FXML
    private TableColumn<FormulirData, String> colNamaDepan;
    @FXML
    private TableColumn<FormulirData, String> colNamaBelakang;
    @FXML
    private TableColumn<FormulirData, String> colNomorKTP;
    @FXML
    private TableColumn<FormulirData, String> colAlamatLengkap;
    @FXML
    private TableColumn<FormulirData, String> colBankPilihan;
    @FXML
    private TableColumn<FormulirData, String> colNomorRekening;
    @FXML
    private TableColumn<FormulirData, String> colNominalPencairan;
    @FXML
    private TableColumn<FormulirData, String> colNomorHandphone;
    @FXML
    private TableColumn<FormulirData, String> colAlamatEmail;

    // LinkedList untuk menyimpan data formulir
    private LinkedList<FormulirData> formDataList;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inisialisasi TableColumn dengan properti dari FormulirData
        colNamaDepan.setCellValueFactory(new PropertyValueFactory<>("namaDepan"));
        colNamaBelakang.setCellValueFactory(new PropertyValueFactory<>("namaBelakang"));
        colNomorKTP.setCellValueFactory(new PropertyValueFactory<>("nomorKTP"));
        colAlamatLengkap.setCellValueFactory(new PropertyValueFactory<>("alamatLengkap"));
        colBankPilihan.setCellValueFactory(new PropertyValueFactory<>("bankPilihan"));
        colNomorRekening.setCellValueFactory(new PropertyValueFactory<>("nomorRekening"));
        colNominalPencairan.setCellValueFactory(new PropertyValueFactory<>("nominalPencairan"));
        colNomorHandphone.setCellValueFactory(new PropertyValueFactory<>("nomorHandphone"));
        colAlamatEmail.setCellValueFactory(new PropertyValueFactory<>("alamatEmail"));

        // Inisialisasi LinkedList
        formDataList = new LinkedList<>();

        // Muat data dari XML dan set data awal untuk TableView
        formDataList.addAll(XMLHandler.loadFormDataFromXML("data_formulir_pencairan_dana.xml"));
        showFormDataOnTableView();
    }

    public void addFormData(FormulirData data) {
        // Tambahkan data baru ke LinkedList
        formDataList.add(data);

        // Simpan data ke XML
        XMLHandler.saveFormDataToXML(formDataList, "data_formulir_pencairan_dana.xml");

        // Perbarui TableView
        showFormDataOnTableView();
    }

    private void showFormDataOnTableView() {
        // Buat ObservableList dari LinkedList
        ObservableList<FormulirData> observableList = FXCollections.observableArrayList(formDataList);

        // Set data pada TableView
        tableViewFormulirPencairanDana.setItems(observableList);
    }

    @FXML
    private void handleBack() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Tampilan_Awal/TampilanAwal.fxml"));
            Stage stage = (Stage) tableViewFormulirPencairanDana.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
