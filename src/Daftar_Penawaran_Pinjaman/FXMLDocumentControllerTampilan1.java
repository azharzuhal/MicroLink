package Daftar_Penawaran_Pinjaman;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLDocumentControllerTampilan1 implements Initializable {

    @FXML
    private Button buttonPilih1;

    @FXML
    private Button buttonPilih2;

    @FXML
    private Button buttonPilih3;

    @FXML
    private Button buttonPilih4;

    @FXML
    private Button buttonBack;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent tampilan2Parent = FXMLLoader.load(getClass().getResource("/Daftar_Penawaran_Pinjaman/FXMLDocumentTampilan2.fxml"));
        Scene tampilan2Scene = new Scene(tampilan2Parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tampilan2Scene);
        window.show();
    }

    @FXML
    private void handleButtonBackAction(ActionEvent event) throws IOException {
        // Logic untuk kembali ke tampilan sebelumnya, misalnya tampilan utama
        Parent mainParent = FXMLLoader.load(getClass().getResource("/Tampilan_Awal/TampilanAwal.fxml"));
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
}
