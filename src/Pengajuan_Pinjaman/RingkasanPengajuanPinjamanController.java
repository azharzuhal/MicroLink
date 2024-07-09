package Pengajuan_Pinjaman;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class RingkasanPengajuanPinjamanController {

    @FXML private Label namaLengkapLabel;
    @FXML private Label nomorIdentitasLabel;
    @FXML private Label alamatLabel;
    @FXML private Label nomorTeleponLabel;
    @FXML private Label emailLabel;
    @FXML private Label pendapatanBulananLabel;
    @FXML private Label pengeluaranBulananLabel;
    @FXML private Label sumberPenghasilanLabel;
    @FXML private Label jumlahPinjamanLabel;
    @FXML private Label usahaYangDibangunLabel;
    @FXML private Label jangkaWaktuPinjamanLabel;
    @FXML private Label pekerjaanLabel;
    @FXML private Label namaPerusahaanLabel;
    @FXML private Label alamatTempatKerjaLabel;
    @FXML private Label nomorTeleponTempatKerjaLabel;
    @FXML private Label dokumenPendukungLabel;

    private PengajuanPinjaman pengajuan;

    public void setPengajuanData(PengajuanPinjaman pengajuan) {
        this.pengajuan = pengajuan;
        namaLengkapLabel.setText(pengajuan.getNamaLengkap());
        nomorIdentitasLabel.setText(pengajuan.getNomorIdentitas());
        alamatLabel.setText(pengajuan.getAlamat());
        nomorTeleponLabel.setText(pengajuan.getNomorTelepon());
        emailLabel.setText(pengajuan.getEmail());
        pendapatanBulananLabel.setText(pengajuan.getPendapatanBulanan());
        pengeluaranBulananLabel.setText(pengajuan.getPengeluaranBulanan());
        sumberPenghasilanLabel.setText(pengajuan.getSumberPenghasilan());
        jumlahPinjamanLabel.setText(pengajuan.getJumlahPinjaman());
        usahaYangDibangunLabel.setText(pengajuan.getUsahaYangDibangun());
        jangkaWaktuPinjamanLabel.setText(pengajuan.getJangkaWaktuPinjaman());
        pekerjaanLabel.setText(pengajuan.getPekerjaan());
        namaPerusahaanLabel.setText(pengajuan.getNamaPerusahaan());
        alamatTempatKerjaLabel.setText(pengajuan.getAlamatTempatKerja());
        nomorTeleponTempatKerjaLabel.setText(pengajuan.getNomorTeleponTempatKerja());
        dokumenPendukungLabel.setText(pengajuan.getDokumenPendukung());
    }

    @FXML
    private void handleKembali() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PengajuanPinjamanView.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) namaLengkapLabel.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
