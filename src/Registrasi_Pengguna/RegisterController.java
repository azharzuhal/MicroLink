package Registrasi_Pengguna;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegisterController implements Initializable {

    @FXML
    private Button buttonSimpan;

    @FXML
    private Button buttonKembaliMenuLogin;

    @FXML
    private TextField textUsername;

    @FXML
    private TextField textPassword;

    @FXML
    private ChoiceBox<String> cbDaftarSebagai;

    private static List<User> registeredUsers;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonKembaliMenuLogin) {
            Parent loginPage = FXMLLoader.load(getClass().getResource("/Registrasi_Pengguna/LoginView.fxml"));
            Scene loginScene = new Scene(loginPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(loginScene);
            appStage.show();
        } else if (event.getSource() == buttonSimpan) {
            String username = textUsername.getText();
            String password = textPassword.getText();
            String daftarSebagai = cbDaftarSebagai.getValue();
            // Tambahkan logika untuk validasi input jika diperlukan

            // Simpan pengguna baru dengan tanggal dan waktu saat ini
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
            registeredUsers.add(new User(username, password, date, time, daftarSebagai));

            // Simpan pengguna ke XML
            XMLHandler.saveUsersToXML(registeredUsers, "registeredUsers.xml");

            // Kembali ke halaman login
            Parent loginPage = FXMLLoader.load(getClass().getResource("/Registrasi_Pengguna/LoginView.fxml"));
            Scene loginScene = new Scene(loginPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(loginScene);
            appStage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load users from XML
        registeredUsers = XMLHandler.loadUsersFromXML("registeredUsers.xml");

        cbDaftarSebagai.setItems(FXCollections.observableArrayList(
            "Pengusaha", 
            "Investor"));
    }
}
