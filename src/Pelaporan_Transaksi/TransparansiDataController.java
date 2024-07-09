package Pelaporan_Transaksi;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class TransparansiDataController {

    @FXML
    private TextField namaPeminjam;
    
    @FXML
    private TextArea penggunaanDana;
    
    @FXML
    private TextField notaBelanja;

    @FXML
    private void handleBrowse() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pilih Nota Belanja");
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            notaBelanja.setText(file.getAbsolutePath());
        }
    }

    @FXML
    private void handleKirimNota() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Simpan Data Transparansi");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            saveDataToFile(file);
        }
    }

    private void saveDataToFile(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Nama Peminjam: " + namaPeminjam.getText() + "\n");
            writer.write("Penggunaan Dana: " + penggunaanDana.getText() + "\n");
            writer.write("Nota Belanja: " + notaBelanja.getText() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
