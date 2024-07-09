import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class HomeController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void handlePengajuanPinjaman() {
        loadView("/Pengajuan_Pinjaman/PengajuanPinjamanView.fxml");
    }

    @FXML
    private void handleManajemenPinjaman() {
        loadView("/Manajemen_Pinjaman/ManajemenPinjamanView.fxml");
    }

    @FXML
    private void handleEvaluasiRisikoKredit() {
        loadView("/Evaluasi_Risiko_Kredit/EvaluasiRisikoView.fxml");
    }

    @FXML
    private void handlePenawaranPinjaman() {
        loadView("/Penawaran_Pinjaman/PenawaranView.fxml");
    }

    @FXML
    private void handlePencairanDana() {
        loadView("/Pencairan_Dana/PencairanView.fxml");
    }

    @FXML
    private void Registrasi_Pengguna(){
        loadView("/Registrasi_Pengguna/LoginView.fxml");
    }

    @FXML
    private void handlePelaporanTransaksi() {
        loadView("/Pelaporan_Transaksi/item.fxml");
    }

    private void loadView(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
            Parent root = loader.load();

            // Mengatur scene baru di stage yang sudah ada
            stage.setTitle("MicroLink - " + fxmlPath.split("/")[1]);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Tidak dapat memuat tampilan " + fxmlPath);
            alert.showAndWait();
        }
    }
}
