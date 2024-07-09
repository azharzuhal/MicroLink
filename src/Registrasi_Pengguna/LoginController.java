package Registrasi_Pengguna;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonDaftar;

    @FXML
    private TextField textUsername;

    @FXML
    private TextField textPassword;

    private List<User> registeredUsers;

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == buttonDaftar) {
            Parent registerPage = FXMLLoader.load(getClass().getResource("/Registrasi_Pengguna/RegisterView.fxml"));
            Scene registerScene = new Scene(registerPage);
            Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            appStage.setScene(registerScene);
            appStage.show();
        } else if (event.getSource() == buttonLogin) {
            String username = textUsername.getText();
            String password = textPassword.getText();

            // Periksa apakah pengguna terdaftar
            boolean loginSuccess = false;

            for (User user : registeredUsers) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    loginSuccess = true;
                    break;
                }
            }

            if (loginSuccess) {
                // Tampilkan halaman utama setelah login berhasil
                Parent mainPage = FXMLLoader.load(getClass().getResource("/Tampilan_Awal/TampilanAwal.fxml"));
                Scene mainScene = new Scene(mainPage);
                Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                appStage.setScene(mainScene);
                appStage.show();
            } else {
                // Tampilkan pesan kesalahan login
                System.out.println("Login gagal, username atau password salah.");
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load users from XML
        registeredUsers = XMLHandler.loadUsersFromXML("registeredUsers.xml");
    }
}
