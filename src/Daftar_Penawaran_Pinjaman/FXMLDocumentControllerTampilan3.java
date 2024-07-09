package Daftar_Penawaran_Pinjaman;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLDocumentControllerTampilan3 implements Initializable {

    @FXML
    private TableView<PenawaranPinjaman> tableViewDaftarPenawaranPinjaman;

    @FXML
    private Button buttonBack;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Implementasi aksi tombol
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        // Logic untuk kembali ke tampilan sebelumnya, misalnya tampilan utama
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Daftar_Penawaran_Pinjaman/FXMLDocumentTampilan2.fxml"));
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Memuat item
        // Inisialisasi kolom-kolom TableView dengan PropertyValueFactory
        TableColumn<PenawaranPinjaman, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<PenawaranPinjaman, String> colUsaha = new TableColumn<>("Usaha");
        colUsaha.setCellValueFactory(new PropertyValueFactory<>("usaha"));

        TableColumn<PenawaranPinjaman, String> colTanggalInvestasi = new TableColumn<>("Tanggal Investasi");
        colTanggalInvestasi.setCellValueFactory(new PropertyValueFactory<>("tanggalInvestasi"));

        TableColumn<PenawaranPinjaman, String> colJumlahInvestasi = new TableColumn<>("Jumlah Investasi");
        colJumlahInvestasi.setCellValueFactory(new PropertyValueFactory<>("jumlahInvestasi"));

        TableColumn<PenawaranPinjaman, String> colBunga = new TableColumn<>("Bunga");
        colBunga.setCellValueFactory(new PropertyValueFactory<>("bunga"));

        TableColumn<PenawaranPinjaman, String> colBulan = new TableColumn<>("Bulan");
        colBulan.setCellValueFactory(new PropertyValueFactory<>("bulan"));

        TableColumn<PenawaranPinjaman, String> colPengembalianDiterima = new TableColumn<>("Pengembalian Diterima");
        colPengembalianDiterima.setCellValueFactory(new PropertyValueFactory<>("pengembalianDiterima"));

        TableColumn<PenawaranPinjaman, String> colPembayaranTerakhir = new TableColumn<>("Pembayaran Terakhir");
        colPembayaranTerakhir.setCellValueFactory(new PropertyValueFactory<>("pembayaranTerakhir"));

        // Menambahkan kolom-kolom ke TableView
        tableViewDaftarPenawaranPinjaman.getColumns().addAll(colNama, colUsaha, colTanggalInvestasi, colJumlahInvestasi, colBunga, colBulan, colPengembalianDiterima, colPembayaranTerakhir);
    }

    // Metode untuk menginisialisasi data dari FXMLDocumentControllerTampilan2
    public void initializeData(ObservableList<PenawaranPinjaman> listPenawaran) {
        // Set data ke TableView
        tableViewDaftarPenawaranPinjaman.setItems(listPenawaran);
    }
    
}
