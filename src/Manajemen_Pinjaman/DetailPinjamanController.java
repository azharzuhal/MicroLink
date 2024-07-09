package Manajemen_Pinjaman;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class DetailPinjamanController {

    @FXML private Label namaPengajuLabel;
    @FXML private Label jumlahPinjamanLabel;
    @FXML private Label statusPinjamanLabel;
    @FXML private Label tanggalPengajuanLabel;

    private ManajemenPinjaman pinjaman;

    public void setPinjamanData(ManajemenPinjaman pinjaman) {
        this.pinjaman = pinjaman;
        namaPengajuLabel.setText(pinjaman.getNamaPengaju());
        jumlahPinjamanLabel.setText(pinjaman.getJumlahPinjaman());
        statusPinjamanLabel.setText(pinjaman.getStatusPinjaman());
        tanggalPengajuanLabel.setText(pinjaman.getTanggalPengajuan());
    }

    @FXML
    private void handleKembali() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ManajemenPinjamanView.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) namaPengajuLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
