package Evaluasi_Risiko_Kredit;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class EvaluasiRisikoKreditController implements Initializable {

    @FXML
    private Button buttonTambahkanEvaluasi;

    @FXML
    private TextField textNamaPengajuan;

    @FXML
    private TextField textPendapatanBulanan;

    @FXML
    private TextField textPengeluaranBulanan;

    @FXML
    private TextField textJumlahPinjaman;

    @FXML
    private TextField textJangkaWaktuPinjaman;

    @FXML
    private TableView<FormulirData> tableViewEvaluasiRisikoKredit;

    @FXML
    private TableColumn<FormulirData, String> columnNamaPengajuan;

    @FXML
    private TableColumn<FormulirData, String> columnPendapatanBulanan;

    @FXML
    private TableColumn<FormulirData, String> columnPengeluaranBulanan;

    @FXML
    private TableColumn<FormulirData, String> columnJumlahPinjaman;

    @FXML
    private TableColumn<FormulirData, String> columnJangkaWaktuPinjaman;

    private ObservableList<FormulirData> data;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        FormulirData evaluasi = new FormulirData(
                textNamaPengajuan.getText(),
                textPendapatanBulanan.getText(),
                textPengeluaranBulanan.getText(),
                textJumlahPinjaman.getText(),
                textJangkaWaktuPinjaman.getText()
        );
        tableViewEvaluasiRisikoKredit.getItems().add(evaluasi);
        clearTextFields();
    }

    private void clearTextFields() {
        textNamaPengajuan.clear();
        textPendapatanBulanan.clear();
        textPengeluaranBulanan.clear();
        textJumlahPinjaman.clear();
        textJangkaWaktuPinjaman.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        data = FXCollections.observableArrayList();
        columnNamaPengajuan.setCellValueFactory(new PropertyValueFactory<>("namaPengajuan"));
        columnPendapatanBulanan.setCellValueFactory(new PropertyValueFactory<>("pendapatanBulanan"));
        columnPengeluaranBulanan.setCellValueFactory(new PropertyValueFactory<>("pengeluaranBulanan"));
        columnJumlahPinjaman.setCellValueFactory(new PropertyValueFactory<>("jumlahPinjaman"));
        columnJangkaWaktuPinjaman.setCellValueFactory(new PropertyValueFactory<>("jangkaWaktuPinjaman"));
        tableViewEvaluasiRisikoKredit.setItems(data);
    }
}
